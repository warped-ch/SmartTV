package org.dev.warped.smarttv.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "e2eventlist")
public class E2EventList {
    @ElementList(inline = true)
    private List<E2Event> mEventList;

    public List<E2Event> getEventList() {
        return mEventList;
    }
}
