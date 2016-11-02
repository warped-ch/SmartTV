package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Channel;
import org.dev.warped.smarttv.model.E2Event;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoadEpgNowNextEventDone {

    private final ArrayList<Channel> mChannels;

    public LoadEpgNowNextEventDone(List<E2Event> e2Events) {
        // separate E2Events based on their event service reference in individual lists
        // using a LinkedHashMap to keep the order
        Map<String, List<E2Event>> eventListMap = new LinkedHashMap<>();
        for (E2Event e : e2Events) {
            String eventServiceReference = e.getEventServiceReference();
            List<E2Event> eventList = eventListMap.get(eventServiceReference);
            if (eventList == null) {
                eventList = new ArrayList<>();
                eventListMap.put(eventServiceReference, eventList);
            }
            eventList.add(e);
        }

        mChannels = new ArrayList<>();
        for (Map.Entry<String, List<E2Event>> entry : eventListMap.entrySet()) {
            mChannels.add(new Channel(entry.getValue()));
        }
    }

    public ArrayList<Channel> getChannels() {
        return mChannels;
    }
}
