package org.dev.warped.smarttv;

import android.os.Parcel;
import android.os.Parcelable;

import org.dev.warped.smarttv.model.E2Service;

public class Bouquet implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bouquet createFromParcel(Parcel parcel) {
            return new Bouquet(parcel);
        }

        public Bouquet[] newArray(int size) {
            return new Bouquet[size];
        }
    };
    private final String mName;
    private final String mReference;

    public Bouquet(E2Service e2Service) {
        mName = e2Service.getServiceName();
        mReference = e2Service.getServiceReference();
    }

    private Bouquet(Parcel parcel) {
        mName = parcel.readString();
        mReference = parcel.readString();
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
