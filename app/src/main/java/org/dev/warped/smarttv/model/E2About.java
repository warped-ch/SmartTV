package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Andreas Wiedmer on 10.09.2016.
 */
@Root(name = "e2about", strict = false)
public class E2About {
    @Element(name = "e2model")
    private String mModel;
    @Element(name = "e2lanip")
    private String mIPAddress;

    public String getModel() {
        return mModel;
    }

    public String getIPAddress() {
        return mIPAddress;
    }
}
