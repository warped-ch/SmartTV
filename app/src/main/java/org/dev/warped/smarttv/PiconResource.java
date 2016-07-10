package org.dev.warped.smarttv;

/**
 * Created by Andreas Wiedmer on 10.07.2016.
 */
public class PiconResource {
    private final int mResourceId;
    private final String mRegex;

    PiconResource(int resourceId, String regex) {
        mResourceId = resourceId;
        mRegex = regex;
    }

    public int getResourceId() {
        return mResourceId;
    }

    public String getRegex() {
        return mRegex;
    }
}
