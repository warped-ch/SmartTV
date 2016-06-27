package org.dev.warped.smarttv;

import java.util.ArrayList;

/**
 * Created by Andreas Wiedmer on 22.06.2016.
 */
public interface IReceiver {

    enum EReceiverType {
        eEnigma2
    }

    void refreshBouquets();

    /**
     * This is the receiver callback interface must be implemented by the owner of a receiver.
     */
    interface IReceiverCallback {
        void onRefreshBouquetsDone(ArrayList<Bouquet> bouquets);
    }
}
