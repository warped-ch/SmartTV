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

    private final String mName;
    private final String mReference;
    private final ArrayList<EpgEvent> mEpgEvents;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Channel createFromParcel(Parcel parcel) {
            return new Channel(parcel);
        }

        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };

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

    public Channel(Parcel parcel) {
        mName = parcel.readString();
        mReference = parcel.readString();
        // TODO: implement
        mEpgEvents = new ArrayList<>();
        //mEpgEvents = parcel.readArrayList();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeString(mReference);
        parcel.writeArray(mEpgEvents.toArray());
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
