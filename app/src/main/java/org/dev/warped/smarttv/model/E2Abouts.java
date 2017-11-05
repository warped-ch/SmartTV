package org.dev.warped.smarttv.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "e2abouts")
public class E2Abouts {
    @ElementList(inline = true)
    private List<E2About> mAboutList;

    public List<E2About> getAboutList() {
        return mAboutList;
    }
}
