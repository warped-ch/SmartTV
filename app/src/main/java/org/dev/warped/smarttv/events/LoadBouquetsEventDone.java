package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Bouquet;
import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

public class LoadBouquetsEventDone {

    private final ArrayList<Bouquet> mBouquets;

    public LoadBouquetsEventDone(List<E2Service> e2Services) {
        mBouquets = new ArrayList<>();
        for (E2Service s : e2Services) {
            mBouquets.add(new Bouquet(s));
        }
    }

    public ArrayList<Bouquet> getBouquets() {
        return mBouquets;
    }
}
