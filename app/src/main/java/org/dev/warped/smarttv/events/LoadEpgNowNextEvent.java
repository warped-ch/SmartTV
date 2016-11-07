package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Bouquet;

public class LoadEpgNowNextEvent {

    private final Bouquet mBouquet;

    public LoadEpgNowNextEvent(Bouquet bouquet) {
        mBouquet = bouquet;
    }

    public Bouquet getBouquet() {
        return mBouquet;
    }
}
