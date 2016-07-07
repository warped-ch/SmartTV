package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class Channel {

    private final String mName;
    private final String mReference;

    public static ArrayList<Channel> buildChannelList(List<E2Service> e2Services) {
        ArrayList<Channel> channels = new ArrayList<>();
        for(E2Service s : e2Services) {
            channels.add(new Channel(s));
        }
        return channels;
    }

    public Channel(E2Service e2Service) {
        mName = e2Service.getServiceName();
        mReference = e2Service.getServiceReference();
    }

    String getName() {
        return mName;
    }

    String getReference() {
        return mReference;
    }
}
