package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Andreas Wiedmer on 12.07.2016.
 */
@Root(name = "e2simplexmlresult")
public class E2SimpleXmlResult {

    @Element(name = "e2state")
    private String mState;
    @Element(name = "e2statetext")
    private String mStateText;

    public String getState() {
        return mState;
    }

    public String getStateText() {
        return mStateText;
    }
}
