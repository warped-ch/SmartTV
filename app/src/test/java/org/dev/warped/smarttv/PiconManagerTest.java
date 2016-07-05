package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PiconManagerTest {
    @Test
    public void getPicon_Equals_ic_tv() throws Exception {
        assertEquals(R.drawable.ic_tv, PiconManager.getPicon("e2servicename"));
    }

    @Test
    public void getPicon_Equals_srf_info_hd() throws Exception {
        assertEquals(R.drawable.srf_info_hd, PiconManager.getPicon("SRF info HD")); // original e2servicename
        assertEquals(R.drawable.srf_info_hd, PiconManager.getPicon("srf info hd"));
        assertEquals(R.drawable.srf_info_hd, PiconManager.getPicon("SRF INFO HD"));
        assertEquals(R.drawable.srf_info_hd, PiconManager.getPicon("srfinfohd"));
        assertEquals(R.drawable.srf_info_hd, PiconManager.getPicon("SRFINFOHD"));
    }

    @Test
    public void getPicon_NotEquals_srf_info_hd() throws Exception {
        assertNotEquals(R.drawable.srf_info_hd, PiconManager.getPicon("srf info"));
        assertNotEquals(R.drawable.srf_info_hd, PiconManager.getPicon("SRF INFO"));
        assertNotEquals(R.drawable.srf_info_hd, PiconManager.getPicon("srfinfo"));
        assertNotEquals(R.drawable.srf_info_hd, PiconManager.getPicon("SRFINFO"));
    }
}
