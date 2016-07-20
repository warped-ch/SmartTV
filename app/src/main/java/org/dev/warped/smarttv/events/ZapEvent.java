package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Channel;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class ZapEvent {

    private final Channel mChannel;

    public ZapEvent(Channel channel) {
        mChannel = channel;
    }

    public Channel getChannel() {
        return mChannel;
    }
}
