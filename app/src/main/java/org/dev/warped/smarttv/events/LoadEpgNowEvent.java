package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Bouquet;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class LoadEpgNowEvent {

    private final Bouquet mBouquet;

    public LoadEpgNowEvent(Bouquet bouquet) {
        mBouquet = bouquet;
    }

    public Bouquet getBouquet() {
        return mBouquet;
    }
}
