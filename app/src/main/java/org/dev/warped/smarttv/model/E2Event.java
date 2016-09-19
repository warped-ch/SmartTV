package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

import timber.log.Timber;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
@Root(name = "e2event")
public class E2Event {

    /**
     * The event id.
     * Must be of type String because value might be "None".
     */
    @Element(name = "e2eventid")
    private String mEventId;
    /**
     * The event start time in Unix time format.
     * Must be of type String because value might be "None".
     */
    @Element(name = "e2eventstart")
    private String mEventStart;    // Unix time
    /**
     * The event duration in seconds [s].
     * Must be of type String because value might be "None".
     */
    @Element(name = "e2eventduration")
    private String mEventDuration;
    /**
     * The current time in Unix time format.
     * Must be of type String because value might be "None".
     */
    @Element(name = "e2eventcurrenttime")
    private String mEventCurrentTime;
    @Element(name = "e2eventtitle")
    private String mEventTitle;
    @Element(name = "e2eventdescription", required = false)
    private String mEventDescription;
    @Element(name = "e2eventdescriptionextended", required = false)
    private String mEventDescriptionExtended;
    @Element(name = "e2eventservicereference")
    private String mEventServiceReference;
    @Element(name = "e2eventservicename")
    private String mEventServiceName;

    public int getEventId() {
        try {
            return Integer.parseInt(mEventId);
        } catch (NumberFormatException e) {
            Timber.w("getEventId: NumberFormatException caught, returning 0.");
            return 0;
        }
    }

    public Date getEventStart() {
        try {
            return new Date(1000 * (long) Integer.parseInt(mEventStart));
        } catch (NumberFormatException e) {
            Timber.w("getEventStart: NumberFormatException caught, returning 0.");
            return new Date();
        }
    }

    public int getEventDuration() {
        try {
            return Integer.parseInt(mEventDuration);
        } catch (NumberFormatException e) {
            Timber.w("getEventDuration: NumberFormatException caught, returning 0.");
            return 0;
        }
    }

    public Date getEventCurrentTime() {
        try {
            return new Date(1000 * (long) Integer.parseInt(mEventCurrentTime));
        } catch (NumberFormatException e) {
            Timber.w("getEventCurrentTime: NumberFormatException caught, returning 0.");
            return new Date();
        }
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
}
