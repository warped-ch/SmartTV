package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.EpgEvent;
import org.dev.warped.smarttv.model.E2Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class LoadEpgEventsEventDone {

    private final ArrayList<EpgEvent> mEpgEvents;

    public LoadEpgEventsEventDone(List<E2Event> e2Events) {
        mEpgEvents = new ArrayList<>();
        for(E2Event e : e2Events) {
            mEpgEvents.add(new EpgEvent(e));
        }
    }

    public ArrayList<EpgEvent> getEpgEvents() {
        return  mEpgEvents;
    }
}
