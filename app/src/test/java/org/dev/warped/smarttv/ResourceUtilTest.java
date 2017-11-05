package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceUtilTest {

    @Test
    public void getReceiverType_eUnknown() throws Exception {
        assertEquals(ReceiverClient.EReceiverType.eUnknown, ResourceUtil.getReceiverType(null));
        assertEquals(ReceiverClient.EReceiverType.eUnknown, ResourceUtil.getReceiverType(""));
        assertEquals(ReceiverClient.EReceiverType.eUnknown, ResourceUtil.getReceiverType("Dreambox"));
    }

    @Test
    public void getReceiverType() throws Exception {
        assertEquals(ReceiverClient.EReceiverType.eDM500HD, ResourceUtil.getReceiverType("dm500hd"));
        assertEquals(ReceiverClient.EReceiverType.eDM500HDV2, ResourceUtil.getReceiverType("dm500hdv2"));
        assertEquals(ReceiverClient.EReceiverType.eDM800, ResourceUtil.getReceiverType("dm800"));
        assertEquals(ReceiverClient.EReceiverType.eDM800SE, ResourceUtil.getReceiverType("dm800se"));
        assertEquals(ReceiverClient.EReceiverType.eDM800SEV2, ResourceUtil.getReceiverType("dm800sev2"));
        assertEquals(ReceiverClient.EReceiverType.eDM7020HD, ResourceUtil.getReceiverType("dm7020hd"));
        assertEquals(ReceiverClient.EReceiverType.eDM7020HDV2, ResourceUtil.getReceiverType("dm7020hdv2"));
        assertEquals(ReceiverClient.EReceiverType.eDM8000, ResourceUtil.getReceiverType("dm8000"));
    }

    @Test
    public void getReceiverTypeValue() throws Exception {
        assertEquals("dm500hd", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM500HD));
        assertEquals("dm500hdv2", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM500HDV2));
        assertEquals("dm800", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM800));
        assertEquals("dm800se", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM800SE));
        assertEquals("dm800sev2", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM800SEV2));
        assertEquals("dm7020hd", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM7020HD));
        assertEquals("dm7020hdv2", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM7020HDV2));
        assertEquals("dm8000", ResourceUtil.getReceiverTypeValue(ReceiverClient.EReceiverType.eDM8000));
    }
}
