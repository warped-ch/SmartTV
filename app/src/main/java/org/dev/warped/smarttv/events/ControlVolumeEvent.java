package org.dev.warped.smarttv.events;

public class ControlVolumeEvent {
    private final EVolumeControlType mVolumeControlType;

    public ControlVolumeEvent(EVolumeControlType volumeControl) {
        mVolumeControlType = volumeControl;
    }

    public EVolumeControlType getVolumeControlType() {
        return mVolumeControlType;
    }

    public enum EVolumeControlType {
        eDown,
        eUp
    }
}
