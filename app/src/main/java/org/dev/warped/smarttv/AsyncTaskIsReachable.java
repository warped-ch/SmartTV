package org.dev.warped.smarttv;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetAddress;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 15.09.2016.
 */
class AsyncTaskIsReachable extends AsyncTask<String, Void, Boolean> {

    private AsyncResponseDelegateReachable mDelegate;

    public AsyncTaskIsReachable() {}

    public AsyncTaskIsReachable(AsyncResponseDelegateReachable delegate) {
        mDelegate = delegate;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String address = params[0];
        try {
            InetAddress inetAddress = InetAddress.getByName(address);
            return inetAddress.isReachable(1000);
        } catch (IOException e) {
            Timber.e("doInBackground: IOException caught.");
        } catch (SecurityException e) {
            Timber.e(e, "doInBackground: SecurityException caught.");
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean reachable) {
        if (null != mDelegate) {
            mDelegate.onPostExecuteIsReachable(reachable);
        }
    }

    public interface AsyncResponseDelegateReachable {
        void onPostExecuteIsReachable(Boolean reachable);
    }
}
