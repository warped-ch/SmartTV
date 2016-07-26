package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
public class EpgEvent {

    private final int mId;
    private final Date mStartTime;
    private final Date mEndTime;
    private final Date mCurrentTime;
    private final String mTitle;
    private final String mDescription;
    private final String mDescriptionExtended;

    public EpgEvent(E2Event event) {
        mId = event.getEventId();
        mStartTime = event.getEventStart();
        mEndTime = new Date(event.getEventStart().getTime() + event.getEventDuration() * 1000);
        mCurrentTime = event.getEventCurrentTime();
        mTitle = event.getEventTitle();
        mDescription = event.getEventDescription();
        mDescriptionExtended = event.getEventDescriptionExtended();
    }

    public int getId() {
        return mId;
    }

    public String getStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        TimeZone timeZone = TimeZone.getDefault();
        sdf.setTimeZone(timeZone);
        return sdf.format(mStartTime);
    }

    public String getEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(mEndTime);
    }

    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(mCurrentTime);
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

    public int calcProgress() {
        return (int) ((100.0 / (mEndTime.getTime() - mStartTime.getTime())) * (mCurrentTime.getTime() - mStartTime.getTime()));
    }
}
