package org.dev.warped.smarttv.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
@Root(name = "e2eventlist")
public class E2EventList {
    public List<E2Event> getEventList() {
        return mEventList;
    }

    @ElementList(inline = true)
    private List<E2Event> mEventList;
}
