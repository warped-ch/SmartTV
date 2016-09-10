package org.dev.warped.smarttv.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Andreas Wiedmer on 10.09.2016.
 */
@Root(name = "e2abouts")
public class E2Abouts {
    public List<E2About> getAboutList() {
        return mAboutList;
    }

    @ElementList(inline = true)
    private List<E2About> mAboutList;
}
