package org.dev.warped.smarttv;

import android.os.Parcel;
import android.os.Parcelable;

import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
public class Bouquet implements Parcelable {

    private final String mName;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bouquet createFromParcel(Parcel parcel) {
            return new Bouquet(parcel);
        }

        public Bouquet[] newArray(int size) {
            return new Bouquet[size];
        }
    };

    public static ArrayList<Bouquet> buildBouquetList(List<E2Service> e2Services) {
        ArrayList<Bouquet> bouquets = new ArrayList<>();
        for(E2Service s : e2Services) {
            bouquets.add(new Bouquet(s));
        }
        return bouquets;
    }

    public Bouquet(Parcel parcel) {
        mName = parcel.readString();
    }

    public Bouquet(E2Service e2Service) {
        mName = e2Service.getServiceName();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mName);
    }

    String getName() {
        return mName;
    }
}
