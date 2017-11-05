package org.dev.warped.smarttv.model;

import org.simpleframework.xml.Element;

public class E2Volume {

    @Element(name = "e2result")
    private String mResult;
    @Element(name = "e2resulttext")
    private String mResultText;
    @Element(name = "e2current")
    private int mCurrent;
    @Element(name = "e2ismuted")
    private String mIsMuted;

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
}
