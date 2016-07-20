package org.dev.warped.smarttv.events;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class LoadEpgNowErrorEvent extends ErrorEvent {

    public LoadEpgNowErrorEvent(Throwable throwable) {
        super(throwable);
    }
}
