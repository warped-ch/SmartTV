package org.dev.warped.smarttv;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
public class Bouquet implements Parcelable {

    private final String m_Name;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bouquet createFromParcel(Parcel parcel) {
            return new Bouquet(parcel);
        }

        public Bouquet[] newArray(int size) {
            return new Bouquet[size];
        }
    };

    public Bouquet(Parcel parcel) {
        m_Name = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(m_Name);
    }

    Bouquet(String name) {
        m_Name = name;
    }

    String getName() {
        return m_Name;
    }
}
