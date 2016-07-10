package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PiconManagerTest {
    @Test
    public void getPicon_default() throws Exception {
        assertEquals(R.drawable.ic_tv, PiconManager.getPicon(""));
        assertEquals(R.drawable.ic_tv, PiconManager.getPicon(null));
        assertEquals(R.drawable.ic_tv, PiconManager.getPicon("e2servicename"));
    }

    @Test
    public void getPicon_3plushd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("3+ HD")); // original e2servicename
    }

    @Test
    public void getPicon_3sathd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_3sathd;
        assertEquals(piconResourceId, PiconManager.getPicon("3sat HD")); // original e2servicename
    }

    @Test
    public void getPicon_aehd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("A&E HD")); // original e2servicename
    }

    @Test
    public void getPicon_adultchannel() throws Exception {
        int piconResourceId = R.drawable.picon_dark_adultchannel;
        assertEquals(piconResourceId, PiconManager.getPicon("Adult Channel")); // original e2servicename
    }

    @Test
    public void getPicon_aljazeeraenglish() throws Exception {
        int piconResourceId = R.drawable.picon_dark_aljazeeraenglish;
        assertEquals(piconResourceId, PiconManager.getPicon("Al Jazeera English")); // original e2servicename
    }

    @Test
    public void getPicon_animalplanethd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_animalplanethd;
        assertEquals(piconResourceId, PiconManager.getPicon("Animal Planet HD")); // original e2servicename
    }

    @Test
    public void getPicon_ardalpha() throws Exception {
        int piconResourceId = R.drawable.picon_dark_ardalpha;
        assertEquals(piconResourceId, PiconManager.getPicon("ARD-alpha")); // original e2servicename
    }

    @Test
    public void getPicon_atvavrupa() throws Exception {
        int piconResourceId = R.drawable.picon_dark_atvavrupa;
        assertEquals(piconResourceId, PiconManager.getPicon("atv Avrupa")); // original e2servicename
    }

    @Test
    public void getPicon_axnhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_axnhd;
        assertEquals(piconResourceId, PiconManager.getPicon("AXN HD")); // original e2servicename
    }

    @Test
    public void getPicon_bbcfour_ceebies() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("BBC Four/Cbeebies")); // original e2servicename
    }

    @Test
    public void getPicon_bbcone() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bbcone;
        assertEquals(piconResourceId, PiconManager.getPicon("BBC One")); // original e2servicename
    }

    @Test
    public void getPicon_bbconehd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bbconehd;
        assertEquals(piconResourceId, PiconManager.getPicon("BBC One HD")); // original e2servicename
    }

    @Test
    public void getPicon_bbcthree() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("BBC Three/CBBC")); // original e2servicename
    }

    @Test
    public void getPicon_bbctwohd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bbctwohd;
        assertEquals(piconResourceId, PiconManager.getPicon("BBC Two HD")); // original e2servicename
    }

    @Test
    public void getPicon_bbcworldnews() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bbcworldnews;
        assertEquals(piconResourceId, PiconManager.getPicon("BBC World News")); // original e2servicename
    }

    @Test
    public void getPicon_bibeltv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bibeltv;
        assertEquals(piconResourceId, PiconManager.getPicon("Bibel TV")); // original e2servicename
    }

    @Test
    public void getPicon_bloombergtv() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Bloomberg TV")); // original e2servicename
    }

    @Test
    public void getPicon_bluehustler() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bluehustler;
        assertEquals(piconResourceId, PiconManager.getPicon("Blue Hustler")); // original e2servicename
    }

    @Test
    public void getPicon_bn() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("BN")); // original e2servicename
    }

    @Test
    public void getPicon_bongustohd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bongustohd;
        assertEquals(piconResourceId, PiconManager.getPicon("Bon Gusto HD")); // original e2servicename
    }

    @Test
    public void getPicon_brsudhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_brsudhd;
        assertEquals(piconResourceId, PiconManager.getPicon("BR Süd HD")); // original e2servicename
    }

    @Test
    public void getPicon_bvntv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_bvntv;
        assertEquals(piconResourceId, PiconManager.getPicon("BVN TV")); // original e2servicename
    }

    @Test
    public void getPicon_canale5hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_canale5hd;
        assertEquals(piconResourceId, PiconManager.getPicon("Canale 5 HD")); // original e2servicename
    }

    @Test
    public void getPicon_cartoonnetworkhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Cartoon Network HD (TC)")); // original e2servicename
    }

    @Test
    public void getPicon_cctv4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_cctv4;
        assertEquals(piconResourceId, PiconManager.getPicon("CCTV 4")); // original e2servicename
    }

    @Test
    public void getPicon_cctvnews() throws Exception {
        int piconResourceId = R.drawable.picon_dark_cctvnews;
        assertEquals(piconResourceId, PiconManager.getPicon("CCTV News")); // original e2servicename
    }

    @Test
    public void getPicon_channel5() throws Exception {
        int piconResourceId = R.drawable.picon_dark_channel5;
        assertEquals(piconResourceId, PiconManager.getPicon("Channel 5")); // original e2servicename
    }

    @Test
    public void getPicon_classicahd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_classicahd;
        assertEquals(piconResourceId, PiconManager.getPicon("Classica HD")); // original e2servicename
    }

    @Test
    public void getPicon_cnbc() throws Exception {
        int piconResourceId = R.drawable.picon_dark_cnbc;
        assertEquals(piconResourceId, PiconManager.getPicon("CNBC")); // original e2servicename
    }

    @Test
    public void getPicon_cnnint() throws Exception {
        int piconResourceId = R.drawable.picon_dark_cnnint;
        assertEquals(piconResourceId, PiconManager.getPicon("CNN Int.")); // original e2servicename
    }

    @Test
    public void getPicon_comedyhd_vivahd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Comedy HD/VIVA HD")); // original e2servicename
    }

    @Test
    public void getPicon_d4accl() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("D4aCCL")); // original e2servicename
    }

    @Test
    public void getPicon_diagnostics() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Diagnostics")); // original e2servicename
    }

    @Test
    public void getPicon_dmaxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_dmaxhd;
        assertEquals(piconResourceId, PiconManager.getPicon("DMAX HD")); // original e2servicename
    }

    @Test
    public void getPicon_dorceltv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_dorceltv;
        assertEquals(piconResourceId, PiconManager.getPicon("Dorcel TV")); // original e2servicename
    }

    @Test
    public void getPicon_ehd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_ehd;
        assertEquals(piconResourceId, PiconManager.getPicon("E! HD")); // original e2servicename
    }

    @Test
    public void getPicon_e4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_e4;
        assertEquals(piconResourceId, PiconManager.getPicon("E4")); // original e2servicename
    }

    @Test
    public void getPicon_einsfestivalhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_einsfestivalhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Einsfestival HD")); // original e2servicename
    }

    @Test
    public void getPicon_einsplus() throws Exception {
        int piconResourceId = R.drawable.picon_dark_einsplus;
        assertEquals(piconResourceId, PiconManager.getPicon("EinsPlus")); // original e2servicename
    }

    @Test
    public void getPicon_eurod() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Euro D")); // original e2servicename
    }

    @Test
    public void getPicon_euronews() throws Exception {
        int piconResourceId = R.drawable.picon_dark_euronews;
        assertEquals(piconResourceId, PiconManager.getPicon("euronews")); // original e2servicename
    }

    @Test
    public void getPicon_eurosport1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_eurosport1;
        assertEquals(piconResourceId, PiconManager.getPicon("Eurosport 1")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPicon("Eurosport 1 I")); // original e2servicename
    }

    @Test
    public void getPicon_eurosport2hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_eurosport2hd;
        assertEquals(piconResourceId, PiconManager.getPicon("Eurosport 2 HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPicon("Eurosport 2 I HD")); // original e2servicename
    }

    @Test
    public void getPicon_eurostar() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("EuroStar")); // original e2servicename
    }

    @Test
    public void getPicon_extremesports() throws Exception {
        int piconResourceId = R.drawable.picon_dark_extremesports;
        assertEquals(piconResourceId, PiconManager.getPicon("Extreme Sports")); // original e2servicename
    }

    @Test
    public void getPicon_fashiontv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_fashiontv;
        assertEquals(piconResourceId, PiconManager.getPicon("Fashion TV")); // original e2servicename
    }

    @Test
    public void getPicon_film4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_film4;
        assertEquals(piconResourceId, PiconManager.getPicon("Film 4")); // original e2servicename
    }

    @Test
    public void getPicon_foxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_foxhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Fox HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPicon("Fox HD (TC)")); // original e2servicename
    }

    @Test
    public void getPicon_france2hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_france2hd;
        assertEquals(piconResourceId, PiconManager.getPicon("France 2 HD")); // original e2servicename
    }

    @Test
    public void getPicon_france24() throws Exception {
        int piconResourceId = R.drawable.picon_dark_france24;
        assertEquals(piconResourceId, PiconManager.getPicon("France 24")); // original e2servicename
    }

    @Test
    public void getPicon_france3() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("France 3 (Alsace)")); // original e2servicename
    }

    @Test
    public void getPicon_france4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_france4;
        assertEquals(piconResourceId, PiconManager.getPicon("France 4")); // original e2servicename
    }

    @Test
    public void getPicon_france5() throws Exception {
        int piconResourceId = R.drawable.picon_dark_france5;
        assertEquals(piconResourceId, PiconManager.getPicon("France 5")); // original e2servicename
    }

    @Test
    public void getPicon_gotv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_gotv;
        assertEquals(piconResourceId, PiconManager.getPicon("gotv")); // original e2servicename
    }

    @Test
    public void getPicon_gtv() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("GTV")); // original e2servicename
    }

    @Test
    public void getPicon_gulli() throws Exception {
        int piconResourceId = R.drawable.picon_dark_gulli;
        assertEquals(piconResourceId, PiconManager.getPicon("Gulli")); // original e2servicename
    }

    @Test
    public void getPicon_gutelaunetv() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Gute Laune TV")); // original e2servicename
    }

    @Test
    public void getPicon_hayatplus() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Hayat Plus")); // original e2servicename
    }

    @Test
    public void getPicon_horizonwelcomechannel() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Horizon Welcome Channel")); // original e2servicename
    }

    @Test
    public void getPicon_hrttv1() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("HRT TV 1")); // original e2servicename
    }

    @Test
    public void getPicon_hse24() throws Exception {
        int piconResourceId = R.drawable.picon_dark_hse24;
        assertEquals(piconResourceId, PiconManager.getPicon("HSE24")); // original e2servicename
    }

    @Test
    public void getPicon_hse24extra() throws Exception {
        int piconResourceId = R.drawable.picon_dark_hse24extra;
        assertEquals(piconResourceId, PiconManager.getPicon("HSE24 Extra")); // original e2servicename
    }

    @Test
    public void getPicon_hustlertvhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Hustler TV HD")); // original e2servicename
    }

    @Test
    public void getPicon_infochannel() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Info Channel")); // original e2servicename
    }

    @Test
    public void getPicon_italia1hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_italia1hd;
        assertEquals(piconResourceId, PiconManager.getPicon("Italia 1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_itv2() throws Exception {
        int piconResourceId = R.drawable.picon_dark_itv2;
        assertEquals(piconResourceId, PiconManager.getPicon("ITV 2")); // original e2servicename
    }

    @Test
    public void getPicon_itv3() throws Exception {
        int piconResourceId = R.drawable.picon_dark_itv3;
        assertEquals(piconResourceId, PiconManager.getPicon("ITV 3")); // original e2servicename
    }

    @Test
    public void getPicon_itv4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_itv4;
        assertEquals(piconResourceId, PiconManager.getPicon("ITV 4")); // original e2servicename
    }

    @Test
    public void getPicon_jimjam() throws Exception {
        int piconResourceId = R.drawable.picon_dark_jimjam;
        assertEquals(piconResourceId, PiconManager.getPicon("JimJam")); // original e2servicename
    }

    @Test
    public void getPicon_ktv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_ktv;
        assertEquals(piconResourceId, PiconManager.getPicon("K-TV")); // original e2servicename
    }

    @Test
    public void getPicon_kabeleins() throws Exception {
        int piconResourceId = R.drawable.picon_dark_kabeleins;
        assertEquals(piconResourceId, PiconManager.getPicon("kabel eins")); // original e2servicename
    }

    @Test
    public void getPicon_kabeleinsclassichd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_kabeleinsclassicshd;
        assertEquals(piconResourceId, PiconManager.getPicon("kabel eins classics HD")); // original e2servicename
    }

    @Test
    public void getPicon_kabeleinshd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_kabeleinshd;
        assertEquals(piconResourceId, PiconManager.getPicon("kabel eins HD")); // original e2servicename
    }

    @Test
    public void getPicon_kanal7int() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Kanal 7 Int.")); // original e2servicename
    }

    @Test
    public void getPicon_kikahd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_kikahd;
        assertEquals(piconResourceId, PiconManager.getPicon("KiKA HD")); // original e2servicename
    }

    @Test
    public void getPicon_kinowelthd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Kinowelt HD")); // original e2servicename
    }

    @Test
    public void getPicon_kurdsattv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_kurdsattv;
        assertEquals(piconResourceId, PiconManager.getPicon("Kurdsat TV")); // original e2servicename
    }

    @Test
    public void getPicon_la7() throws Exception {
        int piconResourceId = R.drawable.picon_dark_la7;
        assertEquals(piconResourceId, PiconManager.getPicon("La 7")); // original e2servicename
    }

    @Test
    public void getPicon_m6hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_m6hd;
        assertEquals(piconResourceId, PiconManager.getPicon("M6 HD")); // original e2servicename
    }

    @Test
    public void getPicon_mediasetitalia() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Mediaset Italia")); // original e2servicename
    }

    @Test
    public void getPicon_more4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_more4;
        assertEquals(piconResourceId, PiconManager.getPicon("More 4")); // original e2servicename
    }

    @Test
    public void getPicon_motorstv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_motorstv;
        assertEquals(piconResourceId, PiconManager.getPicon("Motors TV")); // original e2servicename
    }

    @Test
    public void getPicon_mtvbrandnew() throws Exception {
        int piconResourceId = R.drawable.picon_dark_mtvbrandnew;
        assertEquals(piconResourceId, PiconManager.getPicon("MTV Brand New")); // original e2servicename
    }

    @Test
    public void getPicon_mtvdance() throws Exception {
        int piconResourceId = R.drawable.picon_dark_mtvdance;
        assertEquals(piconResourceId, PiconManager.getPicon("MTV Dance")); // original e2servicename
    }

    @Test
    public void getPicon_mtvhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_mtvhd;
        assertEquals(piconResourceId, PiconManager.getPicon("MTV HD")); // original e2servicename
    }

    @Test
    public void getPicon_mtvlivehd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_mtvlivehd;
        assertEquals(piconResourceId, PiconManager.getPicon("MTV Live HD")); // original e2servicename
    }

    @Test
    public void getPicon_mtvmusic() throws Exception {
        int piconResourceId = R.drawable.picon_dark_mtvmusic;
        assertEquals(piconResourceId, PiconManager.getPicon("MTV Music")); // original e2servicename
    }

    @Test
    public void getPicon_ntvhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_ntvhd;
        assertEquals(piconResourceId, PiconManager.getPicon("n-tv HD")); // original e2servicename
    }

    @Test
    public void getPicon_n24hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_n24hd;
        assertEquals(piconResourceId, PiconManager.getPicon("N24 HD")); // original e2servicename
    }

    @Test
    public void getPicon_natgeo() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Nat Geo I")); // original e2servicename
    }

    @Test
    public void getPicon_natgeohd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_natgeohd;
        assertEquals(piconResourceId, PiconManager.getPicon("Nat Geo HD")); // original e2servicename
    }

    @Test
    public void getPicon_natgeowildhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_natgeowildhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Nat Geo Wild HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPicon("Nat Geo Wild HD (TC)")); // original e2servicename
    }

    @Test
    public void getPicon_nauticalchannelhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Nautical Channel HD")); // original e2servicename
    }

    @Test
    public void getPicon_ndrfsndshd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_ndrfsndshd;
        assertEquals(piconResourceId, PiconManager.getPicon("NDR FS NDS HD")); // original e2servicename
    }

    @Test
    public void getPicon_nickjr() throws Exception {
        int piconResourceId = R.drawable.picon_dark_nickjr;
        assertEquals(piconResourceId, PiconManager.getPicon("Nick Jr.")); // original e2servicename
    }

    @Test
    public void getPicon_nickelodeonhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_nickelodeonhd;
        assertEquals(piconResourceId, PiconManager.getPicon("nickelodeon HD")); // original e2servicename
    }

    @Test
    public void getPicon_nt1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_nt1;
        assertEquals(piconResourceId, PiconManager.getPicon("NT1")); // original e2servicename
    }

    @Test
    public void getPicon_ntvavrupa() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("NTV Avrupa")); // original e2servicename
    }

    @Test
    public void getPicon_orf2() throws Exception {
        int piconResourceId = R.drawable.picon_dark_orf2;
        assertEquals(piconResourceId, PiconManager.getPicon("ORF 2")); // original e2servicename
    }

    @Test
    public void getPicon_orf2hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_orf2hd;
        assertEquals(piconResourceId, PiconManager.getPicon("ORF 2 HD")); // original e2servicename
    }

    @Test
    public void getPicon_orfeinshd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("ORF eins HD")); // original e2servicename
    }

    @Test
    public void getPicon_phoenixhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_phoenixhd;
        assertEquals(piconResourceId, PiconManager.getPicon("PHOENIX HD")); // original e2servicename
    }

    @Test
    public void getPicon_pinkextra() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Pink Extra")); // original e2servicename
    }

    @Test
    public void getPicon_pinkplus() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Pink Plus")); // original e2servicename
    }

    @Test
    public void getPicon_planethd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_planethd;
        assertEquals(piconResourceId, PiconManager.getPicon("Planet HD")); // original e2servicename
    }

    @Test
    public void getPicon_powerturk() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Power Türk")); // original e2servicename
    }

    @Test
    public void getPicon_privatetv() throws Exception {
        int piconResourceId = R.drawable.picon_dark_privatetv;
        assertEquals(piconResourceId, PiconManager.getPicon("Private TV")); // original e2servicename
    }

    @Test
    public void getPicon_prosieben() throws Exception {
        int piconResourceId = R.drawable.picon_dark_prosieben;
        assertEquals(piconResourceId, PiconManager.getPicon("ProSieben")); // original e2servicename
    }

    @Test
    public void getPicon_prosiebefunhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("ProSieben FUN HD")); // original e2servicename
    }

    @Test
    public void getPicon_prosiebenhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_prosiebenhd;
        assertEquals(piconResourceId, PiconManager.getPicon("ProSieben HD")); // original e2servicename
    }

    @Test
    public void getPicon_plus8hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Puls 8 HD")); // original e2servicename
    }

    @Test
    public void getPicon_rai1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rai1;
        assertEquals(piconResourceId, PiconManager.getPicon("Rai 1")); // original e2servicename
    }

    @Test
    public void getPicon_rai2() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rai2;
        assertEquals(piconResourceId, PiconManager.getPicon("Rai 2")); // original e2servicename
    }

    @Test
    public void getPicon_rai3() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rai3;
        assertEquals(piconResourceId, PiconManager.getPicon("Rai 3")); // original e2servicename
    }

    @Test
    public void getPicon_rai4() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rai4;
        assertEquals(piconResourceId, PiconManager.getPicon("Rai 4")); // original e2servicename
    }

    @Test
    public void getPicon_rainews24() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rainews24;
        assertEquals(piconResourceId, PiconManager.getPicon("Rai News 24")); // original e2servicename
    }

    @Test
    public void getPicon_raisport1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_raisport1;
        assertEquals(piconResourceId, PiconManager.getPicon("Rai Sport 1")); // original e2servicename
    }

    @Test
    public void getPicon_recordtvint() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Record TV Int.")); // original e2servicename
    }

    @Test
    public void getPicon_rete4hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rete4hd;
        assertEquals(piconResourceId, PiconManager.getPicon("Rete 4 HD")); // original e2servicename
    }

    @Test
    public void getPicon_romancetvhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_romancetvhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Romance TV HD")); // original e2servicename
    }

    @Test
    public void getPicon_rsila1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rsila1;
        assertEquals(piconResourceId, PiconManager.getPicon("RSI LA 1")); // original e2servicename
    }

    @Test
    public void getPicon_rsila1hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rsila1hd;
        assertEquals(piconResourceId, PiconManager.getPicon("RSI LA 1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_rsila2() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rsila2;
        assertEquals(piconResourceId, PiconManager.getPicon("RSI LA 2")); // original e2servicename
    }

    @Test
    public void getPicon_rsila2hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rsila2hd;
        assertEquals(piconResourceId, PiconManager.getPicon("RSI LA 2 HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtk1() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("RTK 1")); // original e2servicename
    }

    @Test
    public void getPicon_rtl() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL")); // original e2servicename
    }

    @Test
    public void getPicon_rtl2() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtl2;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL ")); // original e2servicename
    }

    @Test
    public void getPicon_rtl2hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtl2hd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL 2 HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtlhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtlhd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtllivinghd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtllivinghd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL Living HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtlnitrohd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtlnitrohd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL Nitro HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtlpassionhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtlpassionhd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTL Passion HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtrplaneta() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("RTR Planeta")); // original e2servicename
    }

    @Test
    public void getPicon_rtsdeux() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtsdeux;
        assertEquals(piconResourceId, PiconManager.getPicon("RTS Deux")); // original e2servicename
    }

    @Test
    public void getPicon_rtsdeuxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtsdeuxhd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTS Deux HD")); // original e2servicename
    }

    @Test
    public void getPicon_rtssat() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("RTS Sat")); // original e2servicename
    }

    @Test
    public void getPicon_rtsun() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtsun;
        assertEquals(piconResourceId, PiconManager.getPicon("RTS Un")); // original e2servicename
    }

    @Test
    public void getPicon_rtsunhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_rtsunhd;
        assertEquals(piconResourceId, PiconManager.getPicon("RTS Un HD")); // original e2servicename
    }

    @Test
    public void getPicon_russiotoday() throws Exception {
        int piconResourceId = R.drawable.picon_dark_russiatoday;
        assertEquals(piconResourceId, PiconManager.getPicon("Russia Today")); // original e2servicename
    }

    @Test
    public void getPicon_s1hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("S1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_sat1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_sat1;
        assertEquals(piconResourceId, PiconManager.getPicon("SAT.1")); // original e2servicename
    }

    @Test
    public void getPicon_sat1hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_sat1hd;
        assertEquals(piconResourceId, PiconManager.getPicon("SAT.1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_schweiz5() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("SCHWEIZ5")); // original e2servicename
    }

    @Test
    public void getPicon_servustvhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_servustvhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Servus TV HD")); // original e2servicename
    }

    @Test
    public void getPicon_showturk() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Show Türk")); // original e2servicename
    }

    @Test
    public void getPicon_sicint() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("SIC Int.")); // original e2servicename
    }

    @Test
    public void getPicon_sicnoticias() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("SIC Noticias")); // original e2servicename
    }

    @Test
    public void getPicon_sixxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_sixxhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Sixx HD")); // original e2servicename
    }

    @Test
    public void getPicon_sport1ushd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_sport1ushd;
        assertEquals(piconResourceId, PiconManager.getPicon("SPORT1 US HD")); // original e2servicename
    }

    @Test
    public void getPicon_sportdigitalhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_sportdigitalhd;
        assertEquals(piconResourceId, PiconManager.getPicon("sportdigital HD")); // original e2servicename
    }

    @Test
    public void getPicon_srf1() throws Exception {
        int piconResourceId = R.drawable.picon_dark_srf1;
        assertEquals(piconResourceId, PiconManager.getPicon("SRF 1")); // original e2servicename
    }

    @Test
    public void getPicon_srf1hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_srf1hd;
        assertEquals(piconResourceId, PiconManager.getPicon("SRF 1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_srfinfohd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_srfinfohd;
        assertEquals(piconResourceId, PiconManager.getPicon("SRF info HD")); // original e2servicename
    }

    @Test
    public void getPicon_srfzwei() throws Exception {
        int piconResourceId = R.drawable.picon_dark_srfzwei;
        assertEquals(piconResourceId, PiconManager.getPicon("SRF zwei")); // original e2servicename
    }

    @Test
    public void getPicon_srfzweihd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_srfzweihd;
        assertEquals(piconResourceId, PiconManager.getPicon("SRF zwei HD")); // original e2servicename
    }

    @Test
    public void getPicon_startvhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Star TV HD")); // original e2servicename
    }

    @Test
    public void getPicon_stvavrupa() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("STV Avrupa")); // original e2servicename
    }

    @Test
    public void getPicon_superrtl() throws Exception {
        int piconResourceId = R.drawable.picon_dark_superrtl;
        assertEquals(piconResourceId, PiconManager.getPicon("Super RTL")); // original e2servicename
    }

    @Test
    public void getPicon_superrtlhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_superrtlhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Super RTL HD")); // original e2servicename
    }

    @Test
    public void getPicon_swrbwhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_swrbwhd;
        assertEquals(piconResourceId, PiconManager.getPicon("SWR BW HD")); // original e2servicename
    }

    @Test
    public void getPicon_tagesschau24hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_tagesschau24hd;
        assertEquals(piconResourceId, PiconManager.getPicon("tagesschau24 HD")); // original e2servicename
    }

    @Test
    public void getPicon_tele1hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele 1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_tele5() throws Exception {
        int piconResourceId = R.drawable.picon_dark_tele5;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele 5")); // original e2servicename
    }

    @Test
    public void getPicon_telebarnhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele Bärn HD")); // original e2servicename
    }

    @Test
    public void getPicon_teled() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele D")); // original e2servicename
    }

    @Test
    public void getPicon_telem1hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele M1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_teletophd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele Top HD")); // original e2servicename
    }

    @Test
    public void getPicon_telez() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Tele Z")); // original e2servicename
    }

    @Test
    public void getPicon_telebaselhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("Telebasel HD")); // original e2servicename
    }

    @Test
    public void getPicon_telebielingue() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TeleBielingue")); // original e2servicename
    }

    @Test
    public void getPicon_teleticinohd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TeleTicino HD")); // original e2servicename
    }

    @Test
    public void getPicon_tf1hd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_tf1hd;
        assertEquals(piconResourceId, PiconManager.getPicon("TF 1 HD")); // original e2servicename
    }

    @Test
    public void getPicon_tgnthaiglobal() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TGN Thai Global")); // original e2servicename
    }

    @Test
    public void getPicon_tgrthaber() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TGRT Haber")); // original e2servicename
    }

    @Test
    public void getPicon_tntglitzhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TNT Glitz HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPicon("TNT Glitz HD (TC)")); // original e2servicename
    }

    @Test
    public void getPicon_travelchannelhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_travelchannelhd;
        assertEquals(piconResourceId, PiconManager.getPicon("Travel Channel HD")); // original e2servicename
    }

    @Test
    public void getPicon_trtturk() throws Exception {
        int piconResourceId = R.drawable.picon_dark_trtturk;
        assertEquals(piconResourceId, PiconManager.getPicon("TRT-TÜRK")); // original e2servicename
    }

    @Test
    public void getPicon_tv8() throws Exception {
        int piconResourceId = R.drawable.picon_dark_tv8;
        assertEquals(piconResourceId, PiconManager.getPicon("TV 8")); // original e2servicename
    }

    @Test
    public void getPicon_tvcg() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TV CG")); // original e2servicename
    }

    @Test
    public void getPicon_tvgloboint() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TV Globo Int.")); // original e2servicename
    }

    @Test
    public void getPicon_tvsudostschweizhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TV Südostschweiz HD")); // original e2servicename
    }

    @Test
    public void getPicon_tv5monde() throws Exception {
        int piconResourceId = R.drawable.picon_dark_tv5monde;
        assertEquals(piconResourceId, PiconManager.getPicon("TV5MONDE")); // original e2servicename
    }

    @Test
    public void getPicon_tvo() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TVO")); // original e2servicename
    }

    @Test
    public void getPicon_tvsh() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("TVSH")); // original e2servicename
    }

    @Test
    public void getPicon_ukrainetoday() throws Exception {
        int piconResourceId = R.drawable.picon_dark_ukrainetoday;
        assertEquals(piconResourceId, PiconManager.getPicon("Ukraine Today")); // original e2servicename
    }

    @Test
    public void getPicon_vh1classic() throws Exception {
        int piconResourceId = R.drawable.picon_dark_vh1classic;
        assertEquals(piconResourceId, PiconManager.getPicon("VH1-Classic")); // original e2servicename
    }

    @Test
    public void getPicon_vox() throws Exception {
        int piconResourceId = R.drawable.picon_dark_vox;
        assertEquals(piconResourceId, PiconManager.getPicon("VOX")); // original e2servicename
    }

    @Test
    public void getPicon_voxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_voxhd;
        assertEquals(piconResourceId, PiconManager.getPicon("VOX HD")); // original e2servicename
    }

    @Test
    public void getPicon_wdrfernsehenhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconManager.getPicon("WDR Fernsehen HD")); // original e2servicename
    }

    @Test
    public void getPicon_zdfkultur() throws Exception {
        int piconResourceId = R.drawable.picon_dark_zdfkultur;
        assertEquals(piconResourceId, PiconManager.getPicon("zdf.kultur")); // original e2servicename
    }

    @Test
    public void getPicon_zdfneohd() throws Exception {
        int piconResourceId = R.drawable.picon_dark_zdfneohd;
        assertEquals(piconResourceId, PiconManager.getPicon("zdf_neo HD")); // original e2servicename
    }
}
