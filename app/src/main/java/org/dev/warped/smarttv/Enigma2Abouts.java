package org.dev.warped.smarttv;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
@Root(name = "e2abouts")
public class Enigma2Abouts {
    @ElementList(inline = true)
    List<Enigma2About> aboutList;

    @Root(name="e2about", strict=false)
    public static class Enigma2About {
        @Element(name = "e2enigmaversion")
        String enigma2Version;
        @Element(name = "e2imageversion")
        String imageVersion;
    }
}
