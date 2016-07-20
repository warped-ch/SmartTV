package org.dev.warped.smarttv;

import android.support.annotation.DrawableRes;

/**
 * Created by Andreas Wiedmer on 10.07.2016.
 */
public class PiconResource {
    @DrawableRes
    private final int mResourceId;
    private final String mRegex;

    PiconResource(@DrawableRes int resourceId, String regex) {
        mResourceId = resourceId;
        mRegex = regex;
    }

    PiconResource(@DrawableRes int resourceId, String... substrings) {
        mResourceId = resourceId;
        String regEx = "(?i).*";
        for (String s : substrings) {
            regEx += (s + ".*");
        }
        mRegex = regEx;
    }

    @DrawableRes
    public int getResourceId() {
        return mResourceId;
    }

    public String getRegex() {
        return mRegex;
    }
}
