package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;

/**
 * Created by Andreas Wiedmer on 29.08.2016.
 */
public class E2Volume {

    public String getResult() {
        return mResult;
    }

    public String getResultText() {
        return mResultText;
    }

    public int getCurrent() {
        return mCurrent;
    }

    public String isMuted() {
        return mIsMuted;
    }

    @Element(name = "e2result")
    private String mResult;
    @Element(name = "e2resulttext")
    private String mResultText;
    @Element(name = "e2current")
    private int mCurrent;
    @Element(name = "e2ismuted")
    private String mIsMuted;
}
