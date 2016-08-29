package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.model.E2Volume;

/**
 * Created by Andreas Wiedmer on 29.08.2016.
 */
public class ControlVolumeEventDone {
    private final boolean mSuccess;
    private final int mCurrentVolume;

    public ControlVolumeEventDone(E2Volume result) {
        mSuccess = result.getResult().toLowerCase().contains("true");
        mCurrentVolume = result.getCurrent();
    }

    public boolean getSuccess() {
        return mSuccess;
    }

    public int getCurrentVolume() {
        return mCurrentVolume;
    }
}
