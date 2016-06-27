package org.dev.warped.smarttv;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
public class Enigma2Receiver implements IReceiver {

    private final Context m_Context;
    private final IReceiverCallback m_Callback;
    private final String m_URL;

    public Enigma2Receiver(Context context, InetAddress address) {
        m_Context = context;
        m_URL = "http://" + address.getHostAddress();
        if (context instanceof IReceiverCallback) {
            m_Callback = (IReceiverCallback) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement IReceiverCallback");
        }
    }

    public void refreshBouquets() {
        // Request a string response from the provided URL.
        StringRequest request = new StringRequest(Request.Method.GET,
                m_URL + "/web/getservices", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Timber.v("refreshBouquets: response=%s", response);
                m_Callback.onRefreshBouquetsDone(buildBouquetList(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Timber.e("refreshBouquets: error=%s", error.toString());
                if (error instanceof AuthFailureError) {
                    m_Callback.onRefreshBouquetsDone(new ArrayList<Bouquet>());
                }
            }
        });
        // Add the request to the RequestQueue.
        VolleySingleton.getInstance(m_Context).addToRequestQueue(request);
    }

    private ArrayList<Bouquet> buildBouquetList(String response) {
        ArrayList<Bouquet> bouquets = new ArrayList<>();
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new InputSource(new StringReader(response)));

            NodeList nodeList = doc.getElementsByTagName("e2service");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    bouquets.add(new Bouquet(element.getElementsByTagName("e2servicename").item(0).getTextContent()));
                }
            }
        } catch (ParserConfigurationException e) {
            Timber.e(e, "buildBouquetList: doInBackground: ParserConfigurationException exception caught.");
        } catch (IOException e) {
            Timber.e(e, "buildBouquetList: doInBackground: IOException exception caught.");
        } catch (SAXException e) {
            Timber.e(e, "buildBouquetList: doInBackground: SAXException exception caught.");
        }
        return bouquets;
    }
}
