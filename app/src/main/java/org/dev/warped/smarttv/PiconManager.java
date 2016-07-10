package org.dev.warped.smarttv;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class PiconManager {

    private static final String PATTERN_3_PLUS_HD = "(?i)((3)(\\s*\\S*)((\\+)|(plus))(\\s*\\S*)(hd))";
    private static final String PATTERN_3_SAT_HD = "(?i)(((drei)|(3))(\\s*\\S*)(sat)(\\s*\\S*)(hd))";
    private static final String PATTERN_AE_HD = "(?i)((a&e)(\\s*\\S*)(hd))";
    private static final String PATTERN_ADULT_CHANNEL = "(?i)((adult)(\\s*\\S*)(channel))";
    private static final String PATTERN_AL_JAZEERA_ENGLISH = "(?i)((al)(\\s*\\S*)(jazeera)(\\s*\\S*)(english))";
    private static final String PATTERN_ANIMAL_PLANET_HD = "(?i)((animal)(\\s*\\S*)(planet)(\\s*\\S*)(hd))";
    private static final String PATTERN_ARD_ALPHA = "(?i)((ard)(\\s*\\S*)(alpha))";
    private static final String PATTERN_ATV_AVRUPA = "(?i)((atv)(\\s*\\S*)(avrupa))";
    private static final String PATTERN_AXN_HD = "(?i)((axn)(\\s*\\S*)(hd))";




    private static final String PATTERN_SRF_INFO_HD = "(?i)((srf)(\\s*\\S*)(info)(\\s*\\S*)(hd))";
    private static final String PATTERN_SRF_1_HD = "(?i)((srf)(\\s*\\S*)((eins)|(1))(\\s*\\S*)(hd))";
    private static final String PATTERN_SRF_2_HD = "(?i)((srf)(\\s*\\S*)((zwei)|(2))(\\s*\\S*)(hd))";
    private static final String PATTERN_PRO_SIEBEN_HD = "(?i)((pro)(\\s*\\S*)((sieben)|(7))(\\s*\\S*)(hd))";
    private static final String PATTERN_SAT_1_HD = "(?i)((sat)(\\s*\\S*)((eins)|(1))(\\s*\\S*)(hd))";
    private static final String PATTERN_RTL_HD = "(?i)((rtl)(\\s*\\S*)(hd))";

    public static int getPicon(String channelName) {
        int piconResourceId = R.drawable.ic_tv;

        if (null == channelName || channelName.isEmpty()) {
            piconResourceId = R.drawable.ic_tv;
        } else if (channelName.matches(PATTERN_3_PLUS_HD)) {
            // TODO: add missing picon resource
            //piconResourceId = R.drawable.picon_dark_3plushd;
        } else if (channelName.matches(PATTERN_3_SAT_HD)) {
            piconResourceId = R.drawable.picon_dark_3sathd;
        } else if (channelName.matches(PATTERN_AE_HD)) {
            // TODO: add missing picon resource
            //piconResourceId = R.drawable.picon_dark_aehd;
        } else if (channelName.matches(PATTERN_ADULT_CHANNEL)) {
            piconResourceId = R.drawable.picon_dark_adultchannel;
        } else if (channelName.matches(PATTERN_AL_JAZEERA_ENGLISH)) {
            piconResourceId = R.drawable.picon_dark_aljazeeraenglish;
        } else if (channelName.matches(PATTERN_ANIMAL_PLANET_HD)) {
            piconResourceId = R.drawable.picon_dark_animalplanethd;
        } else if (channelName.matches(PATTERN_ARD_ALPHA)) {
            piconResourceId = R.drawable.picon_dark_ardalpha;
        } else if (channelName.matches(PATTERN_ATV_AVRUPA)) {
            piconResourceId = R.drawable.picon_dark_atvavrupa;
        } else if (channelName.matches(PATTERN_AXN_HD)) {
            piconResourceId = R.drawable.picon_dark_axnhd;
        }





        else if (channelName.matches(PATTERN_SRF_INFO_HD)) {
            piconResourceId = R.drawable.picon_dark_srfinfohd;
        } else if (channelName.matches(PATTERN_SRF_1_HD)) {
            piconResourceId = R.drawable.picon_dark_srf1hd;
        } else if (channelName.matches(PATTERN_SRF_2_HD)) {
            piconResourceId = R.drawable.picon_dark_srfzweihd;
        } else if (channelName.matches(PATTERN_PRO_SIEBEN_HD)) {
            piconResourceId = R.drawable.picon_dark_prosiebenhd;
        } else if (channelName.matches(PATTERN_SAT_1_HD)) {
            piconResourceId = R.drawable.picon_dark_sat1hd;
        } else if (channelName.matches(PATTERN_RTL_HD)) {
            piconResourceId = R.drawable.picon_dark_rtlhd;
        }

        return piconResourceId;
    }
}
