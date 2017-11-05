package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "e2service")
public class E2Service {

    @Element(name = "e2servicereference")
    private String mServiceReference;
    @Element(name = "e2servicename")
    private String mServiceName;

    public String getServiceReference() {
        return mServiceReference;
    }

    public String getServiceName() {
        return mServiceName;
    }
}
