package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2Event;
import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
public class ChannelEpg extends Channel {

    private final ArrayList<EpgEvent> mEpgEvents;

    public static ArrayList<ChannelEpg> buildChannelEpgList(List<E2Event> events) {
        ArrayList<ChannelEpg> channels = new ArrayList<>();
        for(E2Event e : events) {
            channels.add(new ChannelEpg(e));
        }
        return channels;
    }

    public ChannelEpg(E2Event event) {
        super(new E2Service(event));
        this.mEpgEvents = new ArrayList<>();
        mEpgEvents.add(new EpgEvent(event));
    }

    public ArrayList<EpgEvent> getEpgEvents() {
        return mEpgEvents;
    }
}
