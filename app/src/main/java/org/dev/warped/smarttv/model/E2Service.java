package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Andreas Wiedmer on 02.07.2016.
 */
@Root(name="e2service")
public class E2Service {

    public E2Service() {
        // required nullary constructor
    }

    public E2Service(E2Event event) {
        this.mServiceReference = event.getEventServiceReference();
        this.mServiceName = event.getEventServiceName();
    }

    public String getServiceReference() {
        return mServiceReference;
    }

    public String getServiceName() {
        return mServiceName;
    }

    @Element(name = "e2servicereference")
    private String mServiceReference;
    @Element(name = "e2servicename")
    private String mServiceName;
}
