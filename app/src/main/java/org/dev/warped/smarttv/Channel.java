package org.dev.warped.smarttv;

import android.os.Parcel;
import android.os.Parcelable;

import org.dev.warped.smarttv.model.E2Event;
import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class Channel implements Parcelable {

    public static final Parcelable.Creator<Channel> CREATOR = new Parcelable.Creator<Channel>() {
        public Channel createFromParcel(Parcel in) {
            return new Channel(in);
        }

        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };
    private final String mName;
    private final String mReference;
    private final List<EpgEvent> mEpgEvents;

    public Channel(E2Service e2Service) {
        mName = e2Service.getServiceName();
        mReference = e2Service.getServiceReference();
        mEpgEvents = new ArrayList<>();
    }

    public Channel(E2Event e2Event) {
        mName = e2Event.getEventServiceName();
        mReference = e2Event.getEventServiceReference();
        mEpgEvents = new ArrayList<>();
        mEpgEvents.add(new EpgEvent(e2Event));
    }

    private Channel(Parcel in) {
        mName = in.readString();
        mReference = in.readString();
        mEpgEvents = new ArrayList<>();
        in.readList(mEpgEvents, List.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeString(mReference);
        out.writeList(mEpgEvents);
    }

    String getName() {
        return mName;
    }

    String getReference() {
        return mReference;
    }

    public List<EpgEvent> getEpgEvents() {
        return mEpgEvents;
    }
}
