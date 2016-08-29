package org.dev.warped.smarttv.events;

/**
 * Created by Andreas Wiedmer on 29.08.2016.
 */
public class ControlVolumeEvent {
    public enum EVolumeControlType {
        eDown,
        eUp
    }

    private final EVolumeControlType mVolumeControlType;

    public ControlVolumeEvent(EVolumeControlType volumeControl) {
        mVolumeControlType = volumeControl;
    }

    public EVolumeControlType getVolumeControlType() {
        return mVolumeControlType;
    }
}
