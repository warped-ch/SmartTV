package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2Event;

import java.util.Date;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
public class EpgEvent {

    private final int mId;
    private final Date mStart;
    private final int mDuration;
    private final Date mCurrentTime;
    private final String mTitle;
    private final String mDescription;
    private final String mDescriptionExtended;

    public EpgEvent(E2Event event) {
        this.mId = event.getEventId();
        this.mStart = new Date(1000 * event.getEventStart());
        this.mDuration = event.getEventDuration();
        this.mCurrentTime = new Date(1000 * event.getEventCurrentTime());
        this.mTitle = event.getEventTitle();
        this.mDescription = event.getEventDescription();
        this.mDescriptionExtended = event.getEventDescriptionExtended();
    }

    public int getId() {
        return mId;
    }

    public Date getStart() {
        return mStart;
    }

    public int getDuration() {
        return mDuration;
    }

    public Date getCurrentTime() {
        return mCurrentTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getDescriptionExtended() {
        return mDescriptionExtended;
    }
}
