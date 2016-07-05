package org.dev.warped.smarttv;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class PiconManager {

    private static final String PATTERN_SRF_INFO_HD = "(?i)((srf\\s*)(info\\s*)(hd))";
    private static final String PATTERN_SRF_1_HD = "(?i)((srf\\s*)((eins\\s*)|(1\\s*))(hd))";
    private static final String PATTERN_SRF_2_HD = "(?i)((srf\\s*)((zwei\\s*)|(2\\s*))(hd))";

    public static int getPicon(String channelName) {
        if (channelName.matches(PATTERN_SRF_INFO_HD)) {
            return R.drawable.srf_info_hd;
        } else if (channelName.matches(PATTERN_SRF_1_HD)) {
            return R.drawable.srf_1_hd;
        }else if (channelName.matches(PATTERN_SRF_2_HD)) {
            return R.drawable.srf_2_hd;
        }
        return R.drawable.ic_tv;
    }
}
