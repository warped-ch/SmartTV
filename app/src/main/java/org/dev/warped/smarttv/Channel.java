package org.dev.warped.smarttv;

import android.os.Parcel;
import android.os.Parcelable;

import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class Channel implements Parcelable {

    private final String mName;
    private final String mReference;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Channel createFromParcel(Parcel parcel) {
            return new Channel(parcel);
        }

        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };

    public static ArrayList<Channel> buildChannelList(List<E2Service> e2Services) {
        ArrayList<Channel> channels = new ArrayList<>();
        for(E2Service s : e2Services) {
            channels.add(new Channel(s));
        }
        return channels;
    }

    public Channel(Parcel parcel) {
        mName = parcel.readString();
        mReference = parcel.readString();
    }

    public Channel(E2Service e2Service) {
        mName = e2Service.getServiceName();
        mReference = e2Service.getServiceReference();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
        parcel.writeString(mReference);
    }

    String getName() {
        return mName;
    }

    String getReference() {
        return mReference;
    }
}
