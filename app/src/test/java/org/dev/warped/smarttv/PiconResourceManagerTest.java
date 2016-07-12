package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PiconResourceManagerTest {
    @Test
    public void getPiconResourceId_default() throws Exception {
        assertEquals(R.drawable.ic_tv, PiconResourceManager.getPiconResourceId(""));
        assertEquals(R.drawable.ic_tv, PiconResourceManager.getPiconResourceId(null));
        assertEquals(R.drawable.ic_tv, PiconResourceManager.getPiconResourceId("e2servicename"));
    }

    @Test
    public void getPiconResourceId_3plushd() throws Exception {
        int piconResourceId = R.drawable.picon_3plushd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("3+ HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_3sathd() throws Exception {
        int piconResourceId = R.drawable.picon_3sathd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("3sat HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_aehd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("A&E HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_adultchannel() throws Exception {
        int piconResourceId = R.drawable.picon_adultchannel;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Adult Channel")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_aljazeeraenglish() throws Exception {
        int piconResourceId = R.drawable.picon_aljazeeraenglish;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Al Jazeera English")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_animalplanethd() throws Exception {
        int piconResourceId = R.drawable.picon_animalplanethd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Animal Planet HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ardalpha() throws Exception {
        int piconResourceId = R.drawable.picon_ardalpha;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ARD-alpha")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_atvavrupa() throws Exception {
        int piconResourceId = R.drawable.picon_atvavrupa;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("atv Avrupa")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_axnhd() throws Exception {
        int piconResourceId = R.drawable.picon_axnhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("AXN HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbcfour_ceebies() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BBC Four/Cbeebies")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbcone() throws Exception {
        int piconResourceId = R.drawable.picon_bbcone;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BBC One")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbconehd() throws Exception {
        int piconResourceId = R.drawable.picon_bbconehd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BBC One HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbcthree() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BBC Three/CBBC")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbctwohd() throws Exception {
        int piconResourceId = R.drawable.picon_bbctwohd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BBC Two HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbcworldnews() throws Exception {
        int piconResourceId = R.drawable.picon_bbcworldnews;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BBC World News")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bibeltv() throws Exception {
        int piconResourceId = R.drawable.picon_bibeltv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Bibel TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bloombergtv() throws Exception {
        int piconResourceId = R.drawable.picon_bloombergtv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Bloomberg TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bluehustler() throws Exception {
        int piconResourceId = R.drawable.picon_bluehustler;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Blue Hustler")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bn() throws Exception {
        int piconResourceId = R.drawable.picon_bn;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BN")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bongustohd() throws Exception {
        int piconResourceId = R.drawable.picon_bongustohd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Bon Gusto HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_brsudhd() throws Exception {
        int piconResourceId = R.drawable.picon_brsudhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BR Süd HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bvntv() throws Exception {
        int piconResourceId = R.drawable.picon_bvntv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("BVN TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_canale5hd() throws Exception {
        int piconResourceId = R.drawable.picon_canale5hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Canale 5 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cartoonnetworkhd() throws Exception {
        int piconResourceId = R.drawable.picon_cartoonnetworkhdtc;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Cartoon Network HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cctv4() throws Exception {
        int piconResourceId = R.drawable.picon_cctv4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("CCTV 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cctvnews() throws Exception {
        int piconResourceId = R.drawable.picon_cctvnews;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("CCTV News")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_channel5() throws Exception {
        int piconResourceId = R.drawable.picon_channel5;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Channel 5")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_classicahd() throws Exception {
        int piconResourceId = R.drawable.picon_classicahd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Classica HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cnbc() throws Exception {
        int piconResourceId = R.drawable.picon_cnbc;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("CNBC")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cnnint() throws Exception {
        int piconResourceId = R.drawable.picon_cnnint;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("CNN Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_comedyhd_vivahd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Comedy HD/VIVA HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_d4accl() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("D4aCCL")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_dmaxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dmaxhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("DMAX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_dorceltv() throws Exception {
        int piconResourceId = R.drawable.picon_dorceltv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Dorcel TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ehd() throws Exception {
        int piconResourceId = R.drawable.picon_ehd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("E! HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_e4() throws Exception {
        int piconResourceId = R.drawable.picon_e4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("E4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_einsfestivalhd() throws Exception {
        int piconResourceId = R.drawable.picon_einsfestivalhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Einsfestival HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_einsplus() throws Exception {
        int piconResourceId = R.drawable.picon_einsplus;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("EinsPlus")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurod() throws Exception {
        int piconResourceId = R.drawable.picon_eurod;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Euro D")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_euronews() throws Exception {
        int piconResourceId = R.drawable.picon_euronews;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("euronews")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurosport1() throws Exception {
        int piconResourceId = R.drawable.picon_eurosport1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Eurosport 1")); // original e2servicename
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Eurosport 1 I")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurosport2hd() throws Exception {
        int piconResourceId = R.drawable.picon_eurosport2hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Eurosport 2 HD")); // original e2servicename
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Eurosport 2 I HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurostar() throws Exception {
        int piconResourceId = R.drawable.picon_eurostar;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("EuroStar")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_extremesports() throws Exception {
        int piconResourceId = R.drawable.picon_extremesports;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Extreme Sports")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_fashiontv() throws Exception {
        int piconResourceId = R.drawable.picon_fashiontv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Fashion TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_film4() throws Exception {
        int piconResourceId = R.drawable.picon_film4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Film 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_foxhd() throws Exception {
        int piconResourceId = R.drawable.picon_foxhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Fox HD")); // original e2servicename
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Fox HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france2hd() throws Exception {
        int piconResourceId = R.drawable.picon_france2hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("France 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france24() throws Exception {
        int piconResourceId = R.drawable.picon_france24;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("France 24")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france3() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("France 3 (Alsace)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france4() throws Exception {
        int piconResourceId = R.drawable.picon_france4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("France 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france5() throws Exception {
        int piconResourceId = R.drawable.picon_france5;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("France 5")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gotv() throws Exception {
        int piconResourceId = R.drawable.picon_gotv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("gotv")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gtv() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("GTV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gulli() throws Exception {
        int piconResourceId = R.drawable.picon_gulli;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Gulli")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gutelaunetv() throws Exception {
        int piconResourceId = R.drawable.picon_gutelaunetv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Gute Laune TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hayatplus() throws Exception {
        int piconResourceId = R.drawable.picon_hayatplus;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Hayat Plus")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hrttv1() throws Exception {
        int piconResourceId = R.drawable.picon_hrttv1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("HRT TV 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hse24() throws Exception {
        int piconResourceId = R.drawable.picon_hse24;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("HSE24")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hse24extra() throws Exception {
        int piconResourceId = R.drawable.picon_hse24extra;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("HSE24 Extra")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hustlertvhd() throws Exception {
        int piconResourceId = R.drawable.picon_hustlertvhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Hustler TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_italia1hd() throws Exception {
        int piconResourceId = R.drawable.picon_italia1hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Italia 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itv2() throws Exception {
        int piconResourceId = R.drawable.picon_itv2;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ITV 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itv3() throws Exception {
        int piconResourceId = R.drawable.picon_itv3;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ITV 3")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itv4() throws Exception {
        int piconResourceId = R.drawable.picon_itv4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ITV 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_jimjam() throws Exception {
        int piconResourceId = R.drawable.picon_jimjam;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("JimJam")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ktv() throws Exception {
        int piconResourceId = R.drawable.picon_ktv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("K-TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kabeleins() throws Exception {
        int piconResourceId = R.drawable.picon_kabeleins;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("kabel eins")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kabeleinsclassichd() throws Exception {
        int piconResourceId = R.drawable.picon_kabeleinsclassicshd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("kabel eins classics HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kabeleinshd() throws Exception {
        int piconResourceId = R.drawable.picon_kabeleinshd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("kabel eins HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kanal7int() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Kanal 7 Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kikahd() throws Exception {
        int piconResourceId = R.drawable.picon_kikahd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("KiKA HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kinowelthd() throws Exception {
        int piconResourceId = R.drawable.picon_kinowelthd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Kinowelt HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kurdsattv() throws Exception {
        int piconResourceId = R.drawable.picon_kurdsattv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Kurdsat TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_la7() throws Exception {
        int piconResourceId = R.drawable.picon_la7;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("La 7")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_m6hd() throws Exception {
        int piconResourceId = R.drawable.picon_m6hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("M6 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mediasetitalia() throws Exception {
        int piconResourceId = R.drawable.picon_mediasetitalia;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Mediaset Italia")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_more4() throws Exception {
        int piconResourceId = R.drawable.picon_more4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("More 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_motorstv() throws Exception {
        int piconResourceId = R.drawable.picon_motorstv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Motors TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvbrandnew() throws Exception {
        int piconResourceId = R.drawable.picon_mtvbrandnew;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("MTV Brand New")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvdance() throws Exception {
        int piconResourceId = R.drawable.picon_mtvdance;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("MTV Dance")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvhd() throws Exception {
        int piconResourceId = R.drawable.picon_mtvhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("MTV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvlivehd() throws Exception {
        int piconResourceId = R.drawable.picon_mtvlivehd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("MTV Live HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvmusic() throws Exception {
        int piconResourceId = R.drawable.picon_mtvmusic;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("MTV Music")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ntvhd() throws Exception {
        int piconResourceId = R.drawable.picon_ntvhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("n-tv HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_n24hd() throws Exception {
        int piconResourceId = R.drawable.picon_n24hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("N24 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_natgeo() throws Exception {
        int piconResourceId = R.drawable.picon_natgeoi;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Nat Geo I")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_natgeohd() throws Exception {
        int piconResourceId = R.drawable.picon_natgeohd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Nat Geo HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_natgeowildhd() throws Exception {
        int piconResourceId = R.drawable.picon_natgeowildhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Nat Geo Wild HD")); // original e2servicename
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Nat Geo Wild HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nauticalchannelhd() throws Exception {
        int piconResourceId = R.drawable.picon_nauticalchannelhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Nautical Channel HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ndrfsndshd() throws Exception {
        int piconResourceId = R.drawable.picon_ndrfsndshd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("NDR FS NDS HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nickjr() throws Exception {
        int piconResourceId = R.drawable.picon_nickjr;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Nick Jr.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nickelodeonhd() throws Exception {
        int piconResourceId = R.drawable.picon_nickelodeonhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("nickelodeon HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nt1() throws Exception {
        int piconResourceId = R.drawable.picon_nt1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("NT1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ntvavrupa() throws Exception {
        int piconResourceId = R.drawable.picon_ntvavrupa;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("NTV Avrupa")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_orf2() throws Exception {
        int piconResourceId = R.drawable.picon_orf2;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ORF 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_orf2hd() throws Exception {
        int piconResourceId = R.drawable.picon_orf2hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ORF 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_orfeinshd() throws Exception {
        int piconResourceId = R.drawable.picon_orfeinshd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ORF eins HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_phoenixhd() throws Exception {
        int piconResourceId = R.drawable.picon_phoenixhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("PHOENIX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_pinkextra() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Pink Extra")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_pinkplus() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Pink Plus")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_planethd() throws Exception {
        int piconResourceId = R.drawable.picon_planethd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Planet HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_powerturk() throws Exception {
        int piconResourceId = R.drawable.picon_powerturk;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Power Türk")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_privatetv() throws Exception {
        int piconResourceId = R.drawable.picon_privatetv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Private TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_prosieben() throws Exception {
        int piconResourceId = R.drawable.picon_prosieben;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ProSieben")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_prosiebenfunhd() throws Exception {
        int piconResourceId = R.drawable.picon_prosiebenfunhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ProSieben FUN HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_prosiebenhd() throws Exception {
        int piconResourceId = R.drawable.picon_prosiebenhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("ProSieben HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_puls8hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Puls 8 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai1() throws Exception {
        int piconResourceId = R.drawable.picon_rai1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rai 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai2() throws Exception {
        int piconResourceId = R.drawable.picon_rai2;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rai 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai3() throws Exception {
        int piconResourceId = R.drawable.picon_rai3;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rai 3")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai4() throws Exception {
        int piconResourceId = R.drawable.picon_rai4;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rai 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rainews24() throws Exception {
        int piconResourceId = R.drawable.picon_rainews24;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rai News 24")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_raisport1() throws Exception {
        int piconResourceId = R.drawable.picon_raisport1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rai Sport 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_recordtvint() throws Exception {
        int piconResourceId = R.drawable.picon_recordtvint;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Record TV Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rete4hd() throws Exception {
        int piconResourceId = R.drawable.picon_rete4hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Rete 4 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_romancetvhd() throws Exception {
        int piconResourceId = R.drawable.picon_romancetvhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Romance TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rsila1() throws Exception {
        int piconResourceId = R.drawable.picon_rsila1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RSI LA 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rsila1hd() throws Exception {
        int piconResourceId = R.drawable.picon_rsila1hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RSI LA 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rsila2() throws Exception {
        int piconResourceId = R.drawable.picon_rsila2;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RSI LA 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rsila2hd() throws Exception {
        int piconResourceId = R.drawable.picon_rsila2hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RSI LA 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtk1() throws Exception {
        int piconResourceId = R.drawable.picon_rtk1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTK 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtl() throws Exception {
        int piconResourceId = R.drawable.picon_rtl;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtl2() throws Exception {
        int piconResourceId = R.drawable.picon_rtl2;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtl2hd() throws Exception {
        int piconResourceId = R.drawable.picon_rtl2hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtlhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtlhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtllivinghd() throws Exception {
        int piconResourceId = R.drawable.picon_rtllivinghd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL Living HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtlnitrohd() throws Exception {
        int piconResourceId = R.drawable.picon_rtlnitrohd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL Nitro HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtlpassionhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtlpassionhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTL Passion HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtrplaneta() throws Exception {
        int piconResourceId = R.drawable.picon_rtrplaneta;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTR Planeta")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtsdeux() throws Exception {
        int piconResourceId = R.drawable.picon_rtsdeux;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTS Deux")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtsdeuxhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtsdeuxhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTS Deux HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtssat() throws Exception {
        int piconResourceId = R.drawable.picon_rtssat;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTS Sat")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtsun() throws Exception {
        int piconResourceId = R.drawable.picon_rtsun;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTS Un")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtsunhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtsunhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("RTS Un HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_russiotoday() throws Exception {
        int piconResourceId = R.drawable.picon_russiatoday;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Russia Today")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_s1hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("S1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sat1() throws Exception {
        int piconResourceId = R.drawable.picon_sat1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SAT.1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sat1hd() throws Exception {
        int piconResourceId = R.drawable.picon_sat1hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SAT.1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_schweiz5() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SCHWEIZ5")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_servustvhd() throws Exception {
        int piconResourceId = R.drawable.picon_servustvhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Servus TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_showturk() throws Exception {
        int piconResourceId = R.drawable.picon_showturk;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Show Türk")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sicint() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SIC Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sicnoticias() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SIC Noticias")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sixxhd() throws Exception {
        int piconResourceId = R.drawable.picon_sixxhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Sixx HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sport1ushd() throws Exception {
        int piconResourceId = R.drawable.picon_sport1ushd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SPORT1 US HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sportdigitalhd() throws Exception {
        int piconResourceId = R.drawable.picon_sportdigitalhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("sportdigital HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srf1() throws Exception {
        int piconResourceId = R.drawable.picon_srf1;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SRF 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srf1hd() throws Exception {
        int piconResourceId = R.drawable.picon_srf1hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SRF 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srfinfohd() throws Exception {
        int piconResourceId = R.drawable.picon_srfinfohd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SRF info HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srfzwei() throws Exception {
        int piconResourceId = R.drawable.picon_srfzwei;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SRF zwei")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srfzweihd() throws Exception {
        int piconResourceId = R.drawable.picon_srfzweihd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SRF zwei HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_startvhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Star TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_stvavrupa() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("STV Avrupa")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_superrtl() throws Exception {
        int piconResourceId = R.drawable.picon_superrtl;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Super RTL")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_superrtlhd() throws Exception {
        int piconResourceId = R.drawable.picon_superrtlhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Super RTL HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_swrbwhd() throws Exception {
        int piconResourceId = R.drawable.picon_swrbwhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("SWR BW HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tagesschau24hd() throws Exception {
        int piconResourceId = R.drawable.picon_tagesschau24hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("tagesschau24 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tele1hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tele5() throws Exception {
        int piconResourceId = R.drawable.picon_tele5;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele 5")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_telebarnhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele Bärn HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_teled() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele D")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_telem1hd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele M1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_teletophd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele Top HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_telez() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Tele Z")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_telebaselhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Telebasel HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_telebielingue() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TeleBielingue")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_teleticinohd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TeleTicino HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tf1hd() throws Exception {
        int piconResourceId = R.drawable.picon_tf1hd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TF 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tgnthaiglobal() throws Exception {
        int piconResourceId = R.drawable.picon_tgnthaiglobal;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TGN Thai Global")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tgrthaber() throws Exception {
        int piconResourceId = R.drawable.picon_tgrthaber;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TGRT Haber")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tntglitzhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TNT Glitz HD")); // original e2servicename
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TNT Glitz HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_travelchannelhd() throws Exception {
        int piconResourceId = R.drawable.picon_travelchannelhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Travel Channel HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_trtturk() throws Exception {
        int piconResourceId = R.drawable.picon_trtturk;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TRT-TÜRK")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tv8() throws Exception {
        int piconResourceId = R.drawable.picon_tv8;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TV 8")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tvcg() throws Exception {
        int piconResourceId = R.drawable.picon_tvcg;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TV CG")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tvgloboint() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TV Globo Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tvsudostschweizhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TV Südostschweiz HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tv5monde() throws Exception {
        int piconResourceId = R.drawable.picon_tv5monde;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TV5MONDE")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tvo() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TVO")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tvsh() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.ic_tv;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("TVSH")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ukrainetoday() throws Exception {
        int piconResourceId = R.drawable.picon_ukrainetoday;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("Ukraine Today")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_vh1classic() throws Exception {
        int piconResourceId = R.drawable.picon_vh1classic;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("VH1-Classic")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_vox() throws Exception {
        int piconResourceId = R.drawable.picon_vox;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("VOX")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_voxhd() throws Exception {
        int piconResourceId = R.drawable.picon_voxhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("VOX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_wdrfernsehenhd() throws Exception {
        // TODO: use correct picon
        int piconResourceId = R.drawable.picon_wdrfernsehenhd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("WDR Fernsehen HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_zdfkultur() throws Exception {
        int piconResourceId = R.drawable.picon_zdfkultur;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("zdf.kultur")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_zdfneohd() throws Exception {
        int piconResourceId = R.drawable.picon_zdfneohd;
        assertEquals(piconResourceId, PiconResourceManager.getPiconResourceId("zdf_neo HD")); // original e2servicename
    }
}
