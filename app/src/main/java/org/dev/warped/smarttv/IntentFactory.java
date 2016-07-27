package org.dev.warped.smarttv;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 27.07.2016.
 */
public class IntentFactory {

    public static void createYouTubeQueryIntent(Context context, View view, String query) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getResources().getString(R.string.package_name_youtube), PackageManager.GET_ACTIVITIES);
            Intent intent = new Intent(Intent.ACTION_SEARCH);
            intent.setPackage(packageInfo.packageName);
            intent.putExtra("query", query);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            Timber.w("createYouTubeQueryIntent: YouTube not available.");
            SnackBarFactory.showSnackBar(view, R.string.snackbar_youtube_app_not_available);
        }
    }

    private IntentFactory() {
    }
}
