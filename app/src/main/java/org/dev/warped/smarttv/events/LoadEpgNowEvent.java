package org.dev.warped.smarttv.events;

import org.dev.warped.smarttv.Bouquet;

public class LoadEpgNowEvent {

    private final Bouquet mBouquet;

    public LoadEpgNowEvent(Bouquet bouquet) {
        mBouquet = bouquet;
    }

    public Bouquet getBouquet() {
        return mBouquet;
    }
}
