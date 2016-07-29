package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.model.E2SimpleXmlResult;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class ZapEventDone {

    private final boolean mSuccess;

    public ZapEventDone(E2SimpleXmlResult result) {
        mSuccess = result.getState().toLowerCase().contains("true");
    }

    public boolean getSuccess() {
        return mSuccess;
    }
}
