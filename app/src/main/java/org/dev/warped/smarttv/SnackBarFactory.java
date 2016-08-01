package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 27.07.2016.
 */
class SnackBarFactory {

    public static void showSnackBar(Activity activity, @StringRes int resId) {
        showSnackBar(activity.findViewById(android.R.id.content), resId);
    }

    public static void showSnackBar(Fragment fragment, @StringRes int resId) {
        showSnackBar(fragment.getView(), resId);
    }

    public static void showSnackBar(View view, @StringRes int resId) {
        if (null != view) {
            Snackbar snackbar = Snackbar.make(view, resId, Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            Timber.w("showSnackBar: view is null.");
        }
    }

    private SnackBarFactory() {
    }
}
