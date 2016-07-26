package org.dev.warped.smarttv.events;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class LoadEpgEventsErrorEvent extends ErrorEvent {

    public LoadEpgEventsErrorEvent(Throwable throwable) {
        super(throwable);
    }
}
