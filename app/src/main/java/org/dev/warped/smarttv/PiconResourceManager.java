package org.dev.warped.smarttv;

import android.support.annotation.DrawableRes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
class PiconResourceManager {

    private static final Map<String, Integer> mPiconResourceIdHashMap;
    static {
        HashMap<String, Integer> HashMapUPC = new HashMap<>();
        HashMapUPC.put("3+ HD", R.drawable.picon_3plushd);
        HashMapUPC.put("3sat HD", R.drawable.picon_3sathd);
        HashMapUPC.put("Al Jazeera English", R.drawable.picon_aljazeeraenglish);
        HashMapUPC.put("Animal Planet HD", R.drawable.picon_animalplanethd);
        HashMapUPC.put("ARD-alpha", R.drawable.picon_ardalpha);
        HashMapUPC.put("arte HD", R.drawable.picon_artehd);
        HashMapUPC.put("atv Avrupa", R.drawable.picon_atvavrupa);
        HashMapUPC.put("AXN HD", R.drawable.picon_axnhd);
        HashMapUPC.put("BBC One", R.drawable.picon_bbcone);
        HashMapUPC.put("BBC One HD", R.drawable.picon_bbconehd);
        HashMapUPC.put("BBC Two HD", R.drawable.picon_bbctwohd);
        HashMapUPC.put("BBC World News", R.drawable.picon_bbcworldnews);
        HashMapUPC.put("Bibel TV", R.drawable.picon_bibeltv);
        HashMapUPC.put("Bloomberg TV", R.drawable.picon_bloombergtv);
        HashMapUPC.put("Blue Hustler", R.drawable.picon_bluehustler);
        HashMapUPC.put("BN", R.drawable.picon_bn);
        HashMapUPC.put("Bon Gusto HD", R.drawable.picon_bongustohd);
        HashMapUPC.put("BR Fernsehen Süd HD", R.drawable.picon_brfernsehensudhd);
        HashMapUPC.put("BVN TV", R.drawable.picon_bvntv);
        HashMapUPC.put("Canale 5 HD", R.drawable.picon_canale5hd);
        HashMapUPC.put("Cartoon Network HD (TC)", R.drawable.picon_cartoonnetworkhdtc);
        HashMapUPC.put("CBBC HD", R.drawable.picon_cbbchd);
        HashMapUPC.put("CCTV 4", R.drawable.picon_cctv4);
        HashMapUPC.put("CCTV News", R.drawable.picon_cctvnews);
        HashMapUPC.put("Channel 4 HD", R.drawable.picon_channel4hd);
        HashMapUPC.put("Channel 5", R.drawable.picon_channel5);
        HashMapUPC.put("Classica HD", R.drawable.picon_classicahd);
        HashMapUPC.put("CNBC", R.drawable.picon_cnbc);
        HashMapUPC.put("CNN Int.", R.drawable.picon_cnnint);
        HashMapUPC.put("Das Erste HD", R.drawable.picon_daserstehd);
        HashMapUPC.put("Disney Cinemagic HD", R.drawable.picon_disneycinemagichd);
        HashMapUPC.put("DMAX HD", R.drawable.picon_dmaxhd);
        HashMapUPC.put("Dorcel XXX HD", R.drawable.picon_dorcelxxxhd);
        HashMapUPC.put("E4", R.drawable.picon_e4);
        HashMapUPC.put("E! HD", R.drawable.picon_ehd);
        HashMapUPC.put("Einsfestival HD", R.drawable.picon_einsfestivalhd);
        HashMapUPC.put("EinsPlus", R.drawable.picon_einsplus);
        HashMapUPC.put("Euro D", R.drawable.picon_eurod);
        HashMapUPC.put("euronews", R.drawable.picon_euronews);
        HashMapUPC.put("Eurosport 1", R.drawable.picon_eurosport1);
        HashMapUPC.put("Eurosport 1 HD", R.drawable.picon_eurosport1hd);
        HashMapUPC.put("Eurosport 1 I", R.drawable.picon_eurosport1);
        HashMapUPC.put("Eurosport 2 HD", R.drawable.picon_eurosport2hd);
        HashMapUPC.put("EuroStar", R.drawable.picon_eurostar);
        HashMapUPC.put("Extreme Sports", R.drawable.picon_extremesports);
        HashMapUPC.put("Film 4", R.drawable.picon_film4);
        HashMapUPC.put("Fox HD", R.drawable.picon_foxhd);
        HashMapUPC.put("FOX HD (TC)", R.drawable.picon_foxhd);
        HashMapUPC.put("France 24", R.drawable.picon_france24);
        HashMapUPC.put("France 2 HD", R.drawable.picon_france2hd);
        HashMapUPC.put("France 4 HD", R.drawable.picon_france4hd);
        HashMapUPC.put("France 5 HD", R.drawable.picon_france5hd);
        HashMapUPC.put("gotv", R.drawable.picon_gotv);
        HashMapUPC.put("Gulli HD", R.drawable.picon_gullihd);
        HashMapUPC.put("Gute Laune TV", R.drawable.picon_gutelaunetv);
        HashMapUPC.put("Hayat Plus", R.drawable.picon_hayatplus);
        HashMapUPC.put("hr-fernsehen HD", R.drawable.picon_hrfernsehenhd);
        HashMapUPC.put("HRT TV 1", R.drawable.picon_hrttv1);
        HashMapUPC.put("HSE24", R.drawable.picon_hse24);
        HashMapUPC.put("HSE24 Extra", R.drawable.picon_hse24extra);
        HashMapUPC.put("Hustler TV HD", R.drawable.picon_hustlertvhd);
        HashMapUPC.put("Italia 1 HD", R.drawable.picon_italia1hd);
        HashMapUPC.put("ITV 2", R.drawable.picon_itv2);
        HashMapUPC.put("ITV 3", R.drawable.picon_itv3);
        HashMapUPC.put("ITV 4", R.drawable.picon_itv4);
        HashMapUPC.put("ITV HD", R.drawable.picon_itvhd);
        HashMapUPC.put("JimJam", R.drawable.picon_jimjam);
        HashMapUPC.put("kabel eins", R.drawable.picon_kabeleins);
        HashMapUPC.put("kabel eins classics HD", R.drawable.picon_kabeleinsclassicshd);
        HashMapUPC.put("kabel eins HD", R.drawable.picon_kabeleinshd);
        HashMapUPC.put("KiKA HD", R.drawable.picon_kikahd);
        HashMapUPC.put("Kinowelt HD", R.drawable.picon_kinowelthd);
        HashMapUPC.put("K-TV", R.drawable.picon_ktv);
        HashMapUPC.put("Kurdsat TV", R.drawable.picon_kurdsattv);
        HashMapUPC.put("La 7", R.drawable.picon_la7);
        HashMapUPC.put("M6 HD", R.drawable.picon_m6hd);
        HashMapUPC.put("MDR Sachsen HD", R.drawable.picon_mdrsachsenhd);
        HashMapUPC.put("Mediaset Italia", R.drawable.picon_mediasetitalia);
        HashMapUPC.put("MGM", R.drawable.picon_mgm);
        HashMapUPC.put("More 4", R.drawable.picon_more4);
        HashMapUPC.put("MTV Brand New", R.drawable.picon_mtvbrandnew);
        HashMapUPC.put("MTV Dance", R.drawable.picon_mtvdance);
        HashMapUPC.put("MTV HD", R.drawable.picon_mtvhd);
        HashMapUPC.put("MTV Live HD", R.drawable.picon_mtvlivehd);
        HashMapUPC.put("MTV Music", R.drawable.picon_mtvmusic);
        HashMapUPC.put("N24 HD", R.drawable.picon_n24hd);
        HashMapUPC.put("Nat Geo HD", R.drawable.picon_natgeohd);
        HashMapUPC.put("Nat Geo I", R.drawable.picon_natgeo);
        HashMapUPC.put("Nat Geo Wild HD", R.drawable.picon_natgeowildhd);
        HashMapUPC.put("Nat Geo Wild HD (TC)", R.drawable.picon_natgeowildhd);
        HashMapUPC.put("NDR FS NDS HD", R.drawable.picon_ndrfsndshd);
        HashMapUPC.put("nickelodeon HD", R.drawable.picon_nickelodeonhd);
        HashMapUPC.put("Nick Jr.", R.drawable.picon_nickjr);
        HashMapUPC.put("NT1", R.drawable.picon_nt1);
        HashMapUPC.put("NTV Avrupa", R.drawable.picon_ntvavrupa);
        HashMapUPC.put("n-tv HD", R.drawable.picon_ntvhd);
        HashMapUPC.put("ORF 2", R.drawable.picon_orf2);
        HashMapUPC.put("ORF 2 HD", R.drawable.picon_orf2hd);
        HashMapUPC.put("ORF eins HD", R.drawable.picon_orfeinshd);
        HashMapUPC.put("PBS America", R.drawable.picon_pbsamerica);
        HashMapUPC.put("PHOENIX HD", R.drawable.picon_phoenixhd);
        HashMapUPC.put("Planet HD", R.drawable.picon_planethd);
        HashMapUPC.put("Power Türk", R.drawable.picon_powerturk);
        HashMapUPC.put("ProSieben", R.drawable.picon_prosieben);
        HashMapUPC.put("ProSieben FUN HD", R.drawable.picon_prosiebenfunhd);
        HashMapUPC.put("ProSieben HD", R.drawable.picon_prosiebenhd);
        HashMapUPC.put("Rai 1", R.drawable.picon_rai1);
        HashMapUPC.put("Rai 2", R.drawable.picon_rai2);
        HashMapUPC.put("Rai 3", R.drawable.picon_rai3);
        HashMapUPC.put("Rai 4", R.drawable.picon_rai4);
        HashMapUPC.put("Rai HD", R.drawable.picon_raihd);
        HashMapUPC.put("Rai News 24", R.drawable.picon_rainews24);
        HashMapUPC.put("Rai Sport 1", R.drawable.picon_raisport1);
        HashMapUPC.put("rbb Berlin HD", R.drawable.picon_rbbberlinhd);
        HashMapUPC.put("Record TV Int.", R.drawable.picon_recordtvint);
        HashMapUPC.put("Rete 4 HD", R.drawable.picon_rete4hd);
        HashMapUPC.put("Romance TV HD", R.drawable.picon_romancetvhd);
        HashMapUPC.put("RSI LA 1 HD", R.drawable.picon_rsila1hd);
        HashMapUPC.put("RSI LA 2 HD", R.drawable.picon_rsila2hd);
        HashMapUPC.put("RTK 1", R.drawable.picon_rtk1);
        HashMapUPC.put("RTL 2", R.drawable.picon_rtl2);
        HashMapUPC.put("RTL 2 HD", R.drawable.picon_rtl2hd);
        HashMapUPC.put("RTL 9 HD", R.drawable.picon_rtl9hd);
        HashMapUPC.put("RTL HD", R.drawable.picon_rtlhd);
        HashMapUPC.put("RTL Living HD", R.drawable.picon_rtllivinghd);
        HashMapUPC.put("RTL Nitro HD", R.drawable.picon_rtlnitrohd);
        HashMapUPC.put("RTL Passion HD", R.drawable.picon_rtlpassionhd);
        HashMapUPC.put("RTR Planeta", R.drawable.picon_rtrplaneta);
        HashMapUPC.put("RTS Deux HD", R.drawable.picon_rtsdeuxhd);
        HashMapUPC.put("RTS Sat", R.drawable.picon_rtssat);
        HashMapUPC.put("RTS Un HD", R.drawable.picon_rtsunhd);
        HashMapUPC.put("Russia Today", R.drawable.picon_russiatoday);
        HashMapUPC.put("SAT.1", R.drawable.picon_sat1);
        HashMapUPC.put("SAT.1 HD", R.drawable.picon_sat1hd);
        HashMapUPC.put("Servus TV HD", R.drawable.picon_servustvhd);
        HashMapUPC.put("Show Türk", R.drawable.picon_showturk);
        HashMapUPC.put("Sixx HD", R.drawable.picon_sixxhd);
        HashMapUPC.put("Sky Bundesliga HD 1", R.drawable.picon_skybundesligahd1);
        HashMapUPC.put("Sky Sport 1", R.drawable.picon_skysport1);
        HashMapUPC.put("SPORT1 HD", R.drawable.picon_sport1hd);
        HashMapUPC.put("SPORT1 US HD", R.drawable.picon_sport1ushd);
        HashMapUPC.put("sportdigital HD", R.drawable.picon_sportdigitalhd);
        HashMapUPC.put("SRF 1 HD", R.drawable.picon_srf1hd);
        HashMapUPC.put("SRF info HD", R.drawable.picon_srfinfohd);
        HashMapUPC.put("SRF zwei HD", R.drawable.picon_srfzweihd);
        HashMapUPC.put("Super RTL", R.drawable.picon_superrtl);
        HashMapUPC.put("Super RTL HD", R.drawable.picon_superrtlhd);
        HashMapUPC.put("SWR BW HD", R.drawable.picon_swrbwhd);
        HashMapUPC.put("tagesschau24 HD", R.drawable.picon_tagesschau24hd);
        HashMapUPC.put("TC Sky Sport 2", R.drawable.picon_tcskysport2);
        HashMapUPC.put("TC Sport 1", R.drawable.picon_tcsport1);
        HashMapUPC.put("Tele 5", R.drawable.picon_tele5);
        HashMapUPC.put("TF 1 HD", R.drawable.picon_tf1hd);
        HashMapUPC.put("TGN Thai Global", R.drawable.picon_tgnthaiglobal);
        HashMapUPC.put("TGRT Haber", R.drawable.picon_tgrthaber);
        HashMapUPC.put("TNT Comedy HD (TC)", R.drawable.picon_tntcomedyhd);
        HashMapUPC.put("Travel Channel HD", R.drawable.picon_travelchannelhd);
        HashMapUPC.put("TRT-TÜRK", R.drawable.picon_trtturk);
        HashMapUPC.put("TV5MONDE", R.drawable.picon_tv5monde);
        HashMapUPC.put("TV CG", R.drawable.picon_tvcg);
        HashMapUPC.put("VH1-Classic", R.drawable.picon_vh1classic);
        HashMapUPC.put("VOX", R.drawable.picon_vox);
        HashMapUPC.put("VOX HD", R.drawable.picon_voxhd);
        HashMapUPC.put("W9 HD", R.drawable.picon_w9hd);
        HashMapUPC.put("WDR Fernsehen HD", R.drawable.picon_wdrfernsehenhd);
        HashMapUPC.put("ZDF HD", R.drawable.picon_zdfhd);
        HashMapUPC.put("ZDFinfo HD", R.drawable.picon_zdfinfohd);
        HashMapUPC.put("zdf.kultur", R.drawable.picon_zdfkultur);
        HashMapUPC.put("zdf_neo HD", R.drawable.picon_zdfneohd);
        mPiconResourceIdHashMap = Collections.unmodifiableMap(HashMapUPC);
    }

    @DrawableRes
    public static int getPiconResourceId(String channelName) {
        if (null != channelName && !channelName.isEmpty()) {
            if (mPiconResourceIdHashMap.containsKey(channelName)) {
                return mPiconResourceIdHashMap.get(channelName);
            }
        }
        return R.drawable.ic_tv;
    }
}
