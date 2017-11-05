package org.dev.warped.smarttv.events;

abstract class EventError {
    private final Throwable mThrowable;

    EventError(Throwable throwable) {
        mThrowable = throwable;
    }

    public Throwable getThrowable() {
        return mThrowable;
    }
}
