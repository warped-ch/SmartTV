package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2Event;
import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class Channel {

    private final String mName;
    private final String mReference;
    private final ArrayList<EpgEvent> mEpgEvents;

    public Channel(E2Service e2Service) {
        mName = e2Service.getServiceName();
        mReference = e2Service.getServiceReference();
        mEpgEvents = new ArrayList<>();
    }

    public Channel(E2Event e2Event) {
        mName = e2Event.getEventServiceName();
        mReference = e2Event.getEventServiceReference();
        mEpgEvents = new ArrayList<>();
        mEpgEvents.add(new EpgEvent(e2Event));
    }

    String getName() {
        return mName;
    }

    String getReference() {
        return mReference;
    }

    public List<EpgEvent> getEpgEvents() {
        return mEpgEvents;
    }
}
