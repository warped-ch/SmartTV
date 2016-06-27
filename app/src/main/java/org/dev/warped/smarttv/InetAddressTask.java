package org.dev.warped.smarttv;

import android.os.AsyncTask;

import java.net.InetAddress;
import java.net.UnknownHostException;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 23.06.2016.
 */
public class InetAddressTask extends AsyncTask<String, Integer, InetAddress> {
    protected InetAddress doInBackground(String... params) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(params[0]);
        } catch (UnknownHostException e) {
            Timber.e(e, "doInBackground: UnknownHostException exception caught.");
        } catch (SecurityException e) {
            Timber.e(e, "doInBackground: SecurityException exception caught.");
        }
        return address;
    }
}
