package org.dev.warped.smarttv;

import com.squareup.otto.Bus;

public class BusProvider {
    private static final BusProvider mInstance = new BusProvider();
    private static final Bus mBus = new Bus();

    private BusProvider() {
    }

    public static BusProvider getInstance() {
        return mInstance;
    }

    public static Bus getBus() {
        return mBus;
    }
}
