package org.dev.warped.smarttv;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 27.07.2016.
 */
public class SnackBarCreator {
    public static void showSnackBar(View view, @StringRes int resId) {
        if (null != view) {
            Snackbar snackbar = Snackbar.make(view, resId, Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            Timber.w("showSnackBar: view is null.");
        }
    }

    private SnackBarCreator() {
    }
}
