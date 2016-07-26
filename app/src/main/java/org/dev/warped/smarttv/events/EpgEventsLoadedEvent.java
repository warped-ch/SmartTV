package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.EpgEvent;
import org.dev.warped.smarttv.model.E2Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class EpgEventsLoadedEvent {

    private final List<EpgEvent> mEpgEvents;

    public EpgEventsLoadedEvent(List<E2Event> e2Events) {
        mEpgEvents = new ArrayList<>();
        for(E2Event e : e2Events) {
            mEpgEvents.add(new EpgEvent(e));
        }
    }

    public List<EpgEvent> getEpgEvents() {
        return  mEpgEvents;
    }
}
