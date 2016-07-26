package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Channel;
import org.dev.warped.smarttv.model.E2Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class EpgNowLoadedEvent {

    private final List<Channel> mChannels;

    public EpgNowLoadedEvent(List<E2Event> events) {
        mChannels = new ArrayList<>();
        for(E2Event e : events) {
            mChannels.add(new Channel(e));
        }
    }

    public List<Channel> getChannels() {
        return  mChannels;
    }
}
