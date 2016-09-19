package org.dev.warped.smarttv;

import android.os.Parcel;
import android.os.Parcelable;

import org.dev.warped.smarttv.model.E2Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Andreas Wiedmer on 07.07.2016.
 */
public class EpgEvent implements Parcelable {

    public static final Parcelable.Creator<EpgEvent> CREATOR = new Parcelable.Creator<EpgEvent>() {
        public EpgEvent createFromParcel(Parcel in) {
            return new EpgEvent(in);
        }

        public EpgEvent[] newArray(int size) {
            return new EpgEvent[size];
        }
    };
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

    private EpgEvent(Parcel in) {
        mId = in.readInt();
        mStartTime = new Date(in.readLong());
        mEndTime = new Date(in.readLong());
        mCurrentTime = new Date(in.readLong());
        mTitle = in.readString();
        mDescription = in.readString();
        mDescriptionExtended = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mId);
        out.writeLong(mStartTime.getTime());
        out.writeLong(mEndTime.getTime());
        out.writeLong(mCurrentTime.getTime());
        out.writeString(mTitle);
        out.writeString(mDescription);
        out.writeString(mDescriptionExtended);
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
        return (mDescriptionExtended != null) ? mDescriptionExtended : "";
    }

    public int calcProgress() {
        return (int) ((100.0 / (mEndTime.getTime() - mStartTime.getTime())) * (mCurrentTime.getTime() - mStartTime.getTime()));
    }
}
