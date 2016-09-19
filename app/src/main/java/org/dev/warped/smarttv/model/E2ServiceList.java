package org.dev.warped.smarttv.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
@Root(name = "e2servicelist")
public class E2ServiceList {
    @ElementList(inline = true)
    private List<E2Service> mServiceList;

    public List<E2Service> getServiceList() {
        return mServiceList;
    }
}
