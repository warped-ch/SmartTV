package org.dev.warped.smarttv.events;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
abstract class ErrorEvent {
    private final Throwable mThrowable;

    public ErrorEvent(Throwable throwable) {
        mThrowable = throwable;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }
}
