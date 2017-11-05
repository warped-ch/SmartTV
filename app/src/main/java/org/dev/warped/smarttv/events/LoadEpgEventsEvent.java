package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Channel;

public class LoadEpgEventsEvent {

    private final Channel mChannel;

    public LoadEpgEventsEvent(Channel channel) {
        mChannel = channel;
    }

    public Channel getChannel() {
        return mChannel;
    }
}
