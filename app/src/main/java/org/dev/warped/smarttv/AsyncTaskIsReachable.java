package org.dev.warped.smarttv;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetAddress;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 15.09.2016.
 */
public class AsyncTaskIsReachable extends AsyncTask<InetAddress, Void, Boolean> {

    private AsyncResponseDelegateReachable mDelegate;

    public AsyncTaskIsReachable() {}

    public AsyncTaskIsReachable(AsyncResponseDelegateReachable delegate) {
        mDelegate = delegate;
    }

    @Override
    protected Boolean doInBackground(InetAddress... params) {
        InetAddress address = params[0];
        try {
            return address.isReachable(3000);
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
