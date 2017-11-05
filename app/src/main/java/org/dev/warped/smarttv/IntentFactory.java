package org.dev.warped.smarttv;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;

import timber.log.Timber;

class IntentFactory {

    private IntentFactory() {
    }

    public static void createIMDbFindIntent(Context context, View view, EpgEvent epgEvent) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getResources().getString(R.string.package_name_imdb), PackageManager.GET_ACTIVITIES);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("imdb:///find?q=" + epgEvent.getTitle()));
            intent.setPackage(packageInfo.packageName);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            Timber.w("createIMDbFindIntent: IMDb app not available.");
            SnackBarFactory.showSnackBar(view, R.string.snackbar_app_not_available_imdb);

            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(
                        context.getResources().getString(R.string.package_name_chrome), PackageManager.GET_ACTIVITIES);
                String url = "http://www.imdb.com/find?q=" + epgEvent.getTitle();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.setPackage(packageInfo.packageName);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            } catch (PackageManager.NameNotFoundException e2) {
                Timber.w("createIMDbFindIntent: Chrome app not available.");
                SnackBarFactory.showSnackBar(view, R.string.snackbar_app_not_available_chrome);
            }
        }
    }

    public static void createYouTubeQueryIntent(Context context, View view, EpgEvent epgEvent) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getResources().getString(R.string.package_name_youtube), PackageManager.GET_ACTIVITIES);
            Intent intent = new Intent(Intent.ACTION_SEARCH);
            intent.setPackage(packageInfo.packageName);
            intent.putExtra("query", epgEvent.getTitle());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            Timber.w("createYouTubeQueryIntent: YouTube app not available.");
            SnackBarFactory.showSnackBar(view, R.string.snackbar_app_not_available_youtube);
        }
    }
}
