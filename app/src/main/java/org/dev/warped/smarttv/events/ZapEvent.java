package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Channel;

public class ZapEvent {

    private final Channel mChannel;

    public ZapEvent(Channel channel) {
        mChannel = channel;
    }

    public Channel getChannel() {
        return mChannel;
    }
}
