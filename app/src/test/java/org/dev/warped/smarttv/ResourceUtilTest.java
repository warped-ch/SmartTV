package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Andreas Wiedmer on 25.07.2016.
 */
public class ResourceUtilTest {

    @Test
    public void getReceiverType_eUnknown() throws Exception {
        assertEquals(ReceiverClient.EReceiverType.eUnknown, ResourceUtil.getReceiverType(null));
        assertEquals(ReceiverClient.EReceiverType.eUnknown, ResourceUtil.getReceiverType(""));
        assertEquals(ReceiverClient.EReceiverType.eUnknown, ResourceUtil.getReceiverType("Dreambox"));
    }

    @Test
    public void getReceiverType_eEnigma2() throws Exception {
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox7025"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox500HD"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox800HDPVR"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox800HDse"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox820HD"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox8000HDPVR"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox7020HD"));
        assertEquals(ReceiverClient.EReceiverType.eEnigma2, ResourceUtil.getReceiverType("Dreambox7080HD"));
    }
}
