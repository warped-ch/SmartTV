package org.dev.warped.smarttv;

import com.squareup.otto.Bus;

/**
 * Created by Andreas Wiedmer on 20.07.2016.
 */
public class BusProvider {
    private static final BusProvider mInstance = new BusProvider();
    private static final Bus mBus = new Bus();

    public static BusProvider getInstance() {
        return mInstance;
    }

    public static Bus getBus() {
        return mBus;
    }

    private BusProvider() {
    }
}
