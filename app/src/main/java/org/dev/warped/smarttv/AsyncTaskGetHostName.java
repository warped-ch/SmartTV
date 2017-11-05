package org.dev.warped.smarttv;

import android.os.AsyncTask;

import java.net.InetAddress;

import timber.log.Timber;

class AsyncTaskGetHostName extends AsyncTask<InetAddress, Void, String> {

    private AsyncResponseDelegateHostName mDelegate;

    public AsyncTaskGetHostName(AsyncResponseDelegateHostName delegate) {
        mDelegate = delegate;
    }

    private AsyncTaskGetHostName() {
    }

    @Override
    protected String doInBackground(InetAddress... params) {
        InetAddress address = params[0];
        try {
            return address.getHostName();
        } catch (SecurityException e) {
            Timber.e(e, "doInBackground: SecurityException exception caught.");
        }
        return address.getHostAddress();
    }

    @Override
    protected void onPostExecute(String result) {
        mDelegate.onPostExecuteGetHostName(result);
    }

    public interface AsyncResponseDelegateHostName {
        void onPostExecuteGetHostName(String hostName);
    }
}
