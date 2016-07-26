package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Channel;

/**
 * Created by Andreas Wiedmer on 26.07.2016.
 */
public class LoadEpgEventsEvent {

    private final Channel mChannel;

    public LoadEpgEventsEvent(Channel channel) {
        mChannel = channel;
    }

    public Channel getChannel() {
        return mChannel;
    }
}
