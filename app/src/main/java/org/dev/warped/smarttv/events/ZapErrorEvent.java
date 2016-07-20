package org.dev.warped.smarttv.events;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class ZapErrorEvent extends ErrorEvent {

    public ZapErrorEvent(Throwable throwable) {
        super(throwable);
    }
}
