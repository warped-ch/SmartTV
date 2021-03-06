package org.dev.warped.smarttv;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;

import androidx.annotation.StringRes;

import com.google.android.material.snackbar.Snackbar;

import timber.log.Timber;

class SnackBarFactory {

    private SnackBarFactory() {
    }

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
}
