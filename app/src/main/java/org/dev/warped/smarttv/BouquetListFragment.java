package org.dev.warped.smarttv;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnBouquetListFragmentInteractionListener}
 * interface.
 */
public class BouquetListFragment extends Fragment {

    private OnBouquetListFragmentInteractionListener m_Listener;
    private BouquetListAdapter m_Adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BouquetListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_Adapter =  new BouquetListAdapter(m_Listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bouquet_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(m_Adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBouquetListFragmentInteractionListener) {
            m_Listener = (OnBouquetListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBouquetListFragmentInteractionListener");
        }

        // TODO, anwi: refresh bouquet list
        Enigma2Client e2Client = new Enigma2Client();
        final Call<Enigma2Abouts> call = e2Client.getApiService().getAbout();
        call.enqueue(new Callback<Enigma2Abouts>() {
            @Override
            public void onResponse(Call<Enigma2Abouts> call, Response<Enigma2Abouts> response) {
                Timber.d("onResponse: \"%s\".", response.body());
                Timber.d("onResponse: aboutList.size=%d.", response.body().aboutList.size());
                Timber.d("onResponse: enigma2Version=%s.", response.body().aboutList.get(0).enigma2Version);
                Timber.d("onResponse: imageVersion=%s.", response.body().aboutList.get(0).imageVersion);
            }
            @Override
            public void onFailure(Call<Enigma2Abouts> call, Throwable t) {
                Timber.w("onFailure: something went wrong");
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        m_Adapter = null;
        m_Listener = null;
    }

    public void setBouquets(ArrayList<Bouquet> bouquets) {
        m_Adapter.setBouquets(bouquets);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnBouquetListFragmentInteractionListener {
        void onShowBouquet(Bouquet bouquet);
    }
}
