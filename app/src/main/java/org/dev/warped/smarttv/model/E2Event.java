package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
@Root(name="e2event")
public class E2Event {

    public int getEventId() {
        return mEventId;
    }

    public int getEventStart() {
        return mEventStart;
    }

    public int getEventDuration() {
        return mEventDuration;
    }

    public int getEventCurrentTime() {
        return mEventCurrentTime;
    }

    public String getEventTitle() {
        return mEventTitle;
    }

    public String getEventDescription() {
        return mEventDescription;
    }

    public String getEventDescriptionExtended() {
        return mEventDescriptionExtended;
    }

    public String getEventServiceReference() {
        return mEventServiceReference;
    }

    public String getEventServiceName() {
        return mEventServiceName;
    }

    @Element(name = "e2eventid")
    private int mEventId;
    @Element(name = "e2eventstart")
    private int mEventStart;    // Unix time
    @Element(name = "e2eventduration")
    private int mEventDuration; // [s]
    @Element(name = "e2eventcurrenttime")
    private int mEventCurrentTime;  // Unix time
    @Element(name = "e2eventtitle")
    private String mEventTitle;
    @Element(name = "e2eventdescription", required = false)
    private String mEventDescription;
    @Element(name = "e2eventdescriptionextended")
    private String mEventDescriptionExtended;
    @Element(name = "e2eventservicereference")
    private String mEventServiceReference;
    @Element(name = "e2eventservicename")
    private String mEventServiceName;
}
