package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Bouquet;
import org.dev.warped.smarttv.model.E2Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class BouquetsLoadedEvent {

    private final List<Bouquet> mBouquets;

    public BouquetsLoadedEvent(List<E2Service> e2Services) {
        mBouquets = new ArrayList<>();
        for(E2Service s : e2Services) {
            mBouquets.add(new Bouquet(s));
        }
    }

    public List<Bouquet> getBouquets() {
        return mBouquets;
    }
}
