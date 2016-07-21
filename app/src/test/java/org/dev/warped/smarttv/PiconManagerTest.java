package org.dev.warped.smarttv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PiconManagerTest {
    @Test
    public void getPiconResourceId_default() throws Exception {
        assertEquals(R.drawable.ic_tv, PiconManager.getPiconResourceId(""));
        assertEquals(R.drawable.ic_tv, PiconManager.getPiconResourceId(null));
        assertEquals(R.drawable.ic_tv, PiconManager.getPiconResourceId("e2servicename"));
    }

    @Test
    public void getPiconResourceId_3plushd() throws Exception {
        int piconResourceId = R.drawable.picon_3plushd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("3+ HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_3sathd() throws Exception {
        int piconResourceId = R.drawable.picon_3sathd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("3sat HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_aljazeeraenglish() throws Exception {
        int piconResourceId = R.drawable.picon_aljazeeraenglish;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Al Jazeera English")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_animalplanethd() throws Exception {
        int piconResourceId = R.drawable.picon_animalplanethd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Animal Planet HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ardalpha() throws Exception {
        int piconResourceId = R.drawable.picon_ardalpha;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ARD-alpha")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_artehd() throws Exception {
        int piconResourceId = R.drawable.picon_artehd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("arte HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_atvavrupa() throws Exception {
        int piconResourceId = R.drawable.picon_atvavrupa;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("atv Avrupa")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_axnhd() throws Exception {
        int piconResourceId = R.drawable.picon_axnhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("AXN HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbcone() throws Exception {
        int piconResourceId = R.drawable.picon_bbcone;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BBC One")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbconehd() throws Exception {
        int piconResourceId = R.drawable.picon_bbconehd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BBC One HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbctwohd() throws Exception {
        int piconResourceId = R.drawable.picon_bbctwohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BBC Two HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bbcworldnews() throws Exception {
        int piconResourceId = R.drawable.picon_bbcworldnews;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BBC World News")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bibeltv() throws Exception {
        int piconResourceId = R.drawable.picon_bibeltv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Bibel TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bloombergtv() throws Exception {
        int piconResourceId = R.drawable.picon_bloombergtv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Bloomberg TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bluehustler() throws Exception {
        int piconResourceId = R.drawable.picon_bluehustler;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Blue Hustler")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bn() throws Exception {
        int piconResourceId = R.drawable.picon_bn;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BN")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bongustohd() throws Exception {
        int piconResourceId = R.drawable.picon_bongustohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Bon Gusto HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_brfernsehensudhd() throws Exception {
        int piconResourceId = R.drawable.picon_brfernsehensudhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BR Fernsehen Süd HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_bvntv() throws Exception {
        int piconResourceId = R.drawable.picon_bvntv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("BVN TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_canale5hd() throws Exception {
        int piconResourceId = R.drawable.picon_canale5hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Canale 5 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cartoonnetworkhd() throws Exception {
        int piconResourceId = R.drawable.picon_cartoonnetworkhdtc;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Cartoon Network HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cbbchd() throws Exception {
        int piconResourceId = R.drawable.picon_cbbchd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("CBBC HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cctv4() throws Exception {
        int piconResourceId = R.drawable.picon_cctv4;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("CCTV 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cctvnews() throws Exception {
        int piconResourceId = R.drawable.picon_cctvnews;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("CCTV News")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_channel4hd() throws Exception {
        int piconResourceId = R.drawable.picon_channel4hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Channel 4 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_channel5() throws Exception {
        int piconResourceId = R.drawable.picon_channel5;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Channel 5")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_classicahd() throws Exception {
        int piconResourceId = R.drawable.picon_classicahd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Classica HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cnbc() throws Exception {
        int piconResourceId = R.drawable.picon_cnbc;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("CNBC")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_cnnint() throws Exception {
        int piconResourceId = R.drawable.picon_cnnint;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("CNN Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_daserstehd() throws Exception {
        int piconResourceId = R.drawable.picon_daserstehd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Das Erste HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_disneycinemagichd() throws Exception {
        int piconResourceId = R.drawable.picon_disneycinemagichd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Disney Cinemagic HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_dmaxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dmaxhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("DMAX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_dorcelxxxhd() throws Exception {
        int piconResourceId = R.drawable.picon_dorcelxxxhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Dorcel XXX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_e4() throws Exception {
        int piconResourceId = R.drawable.picon_e4;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("E4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ehd() throws Exception {
        int piconResourceId = R.drawable.picon_ehd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("E! HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_einsfestivalhd() throws Exception {
        int piconResourceId = R.drawable.picon_einsfestivalhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Einsfestival HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_einsplus() throws Exception {
        int piconResourceId = R.drawable.picon_einsplus;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("EinsPlus")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurod() throws Exception {
        int piconResourceId = R.drawable.picon_eurod;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Euro D")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_euronews() throws Exception {
        int piconResourceId = R.drawable.picon_euronews;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("euronews")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurosport1() throws Exception {
        int piconResourceId = R.drawable.picon_eurosport1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Eurosport 1")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Eurosport 1 I")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurosport1hd() throws Exception {
        int piconResourceId = R.drawable.picon_eurosport1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Eurosport 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurosport2hd() throws Exception {
        int piconResourceId = R.drawable.picon_eurosport2hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Eurosport 2 HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Eurosport 2 I HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_eurostar() throws Exception {
        int piconResourceId = R.drawable.picon_eurostar;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("EuroStar")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_extremesports() throws Exception {
        int piconResourceId = R.drawable.picon_extremesports;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Extreme Sports")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_film4() throws Exception {
        int piconResourceId = R.drawable.picon_film4;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Film 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_foxhd() throws Exception {
        int piconResourceId = R.drawable.picon_foxhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Fox HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("FOX HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france24() throws Exception {
        int piconResourceId = R.drawable.picon_france24;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("France 24")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france2hd() throws Exception {
        int piconResourceId = R.drawable.picon_france2hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("France 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france4hd() throws Exception {
        int piconResourceId = R.drawable.picon_france4hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("France 4 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_france5hd() throws Exception {
        int piconResourceId = R.drawable.picon_france5hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("France 5 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gotv() throws Exception {
        int piconResourceId = R.drawable.picon_gotv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("gotv")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gullihd() throws Exception {
        int piconResourceId = R.drawable.picon_gullihd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Gulli HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_gutelaunetv() throws Exception {
        int piconResourceId = R.drawable.picon_gutelaunetv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Gute Laune TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hayatplus() throws Exception {
        int piconResourceId = R.drawable.picon_hayatplus;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Hayat Plus")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hrfernsehenhd() throws Exception {
        int piconResourceId = R.drawable.picon_hrfernsehenhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("hr-fernsehen HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hrttv1() throws Exception {
        int piconResourceId = R.drawable.picon_hrttv1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("HRT TV 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hse24() throws Exception {
        int piconResourceId = R.drawable.picon_hse24;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("HSE24")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hse24extra() throws Exception {
        int piconResourceId = R.drawable.picon_hse24extra;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("HSE24 Extra")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_hustlertvhd() throws Exception {
        int piconResourceId = R.drawable.picon_hustlertvhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Hustler TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_italia1hd() throws Exception {
        int piconResourceId = R.drawable.picon_italia1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Italia 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itv2() throws Exception {
        int piconResourceId = R.drawable.picon_itv2;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ITV 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itv3() throws Exception {
        int piconResourceId = R.drawable.picon_itv3;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ITV 3")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itv4() throws Exception {
        int piconResourceId = R.drawable.picon_itv4;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ITV 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_itvhd() throws Exception {
        int piconResourceId = R.drawable.picon_itvhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ITV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_jimjam() throws Exception {
        int piconResourceId = R.drawable.picon_jimjam;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("JimJam")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kabeleins() throws Exception {
        int piconResourceId = R.drawable.picon_kabeleins;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("kabel eins")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kabeleinsclassichd() throws Exception {
        int piconResourceId = R.drawable.picon_kabeleinsclassicshd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("kabel eins classics HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kabeleinshd() throws Exception {
        int piconResourceId = R.drawable.picon_kabeleinshd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("kabel eins HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kikahd() throws Exception {
        int piconResourceId = R.drawable.picon_kikahd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("KiKA HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kinowelthd() throws Exception {
        int piconResourceId = R.drawable.picon_kinowelthd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Kinowelt HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ktv() throws Exception {
        int piconResourceId = R.drawable.picon_ktv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("K-TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_kurdsattv() throws Exception {
        int piconResourceId = R.drawable.picon_kurdsattv;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Kurdsat TV")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_la7() throws Exception {
        int piconResourceId = R.drawable.picon_la7;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("La 7")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_m6hd() throws Exception {
        int piconResourceId = R.drawable.picon_m6hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("M6 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mdrsachsenhd() throws Exception {
        int piconResourceId = R.drawable.picon_mdrsachsenhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MDR Sachsen HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mediasetitalia() throws Exception {
        int piconResourceId = R.drawable.picon_mediasetitalia;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Mediaset Italia")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mgm() throws Exception {
        int piconResourceId = R.drawable.picon_mgm;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MGM")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_more4() throws Exception {
        int piconResourceId = R.drawable.picon_more4;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("More 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvbrandnew() throws Exception {
        int piconResourceId = R.drawable.picon_mtvbrandnew;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MTV Brand New")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvdance() throws Exception {
        int piconResourceId = R.drawable.picon_mtvdance;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MTV Dance")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvhd() throws Exception {
        int piconResourceId = R.drawable.picon_mtvhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MTV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvlivehd() throws Exception {
        int piconResourceId = R.drawable.picon_mtvlivehd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MTV Live HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_mtvmusic() throws Exception {
        int piconResourceId = R.drawable.picon_mtvmusic;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("MTV Music")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_n24hd() throws Exception {
        int piconResourceId = R.drawable.picon_n24hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("N24 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_natgeo() throws Exception {
        int piconResourceId = R.drawable.picon_natgeo;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Nat Geo I")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_natgeohd() throws Exception {
        int piconResourceId = R.drawable.picon_natgeohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Nat Geo HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_natgeowildhd() throws Exception {
        int piconResourceId = R.drawable.picon_natgeowildhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Nat Geo Wild HD")); // original e2servicename
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Nat Geo Wild HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ndrfsndshd() throws Exception {
        int piconResourceId = R.drawable.picon_ndrfsndshd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("NDR FS NDS HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nickelodeonhd() throws Exception {
        int piconResourceId = R.drawable.picon_nickelodeonhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("nickelodeon HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nickjr() throws Exception {
        int piconResourceId = R.drawable.picon_nickjr;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Nick Jr.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_nt1() throws Exception {
        int piconResourceId = R.drawable.picon_nt1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("NT1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ntvavrupa() throws Exception {
        int piconResourceId = R.drawable.picon_ntvavrupa;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("NTV Avrupa")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_ntvhd() throws Exception {
        int piconResourceId = R.drawable.picon_ntvhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("n-tv HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_orf2() throws Exception {
        int piconResourceId = R.drawable.picon_orf2;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ORF 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_orf2hd() throws Exception {
        int piconResourceId = R.drawable.picon_orf2hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ORF 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_orfeinshd() throws Exception {
        int piconResourceId = R.drawable.picon_orfeinshd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ORF eins HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_pbsamerica() throws Exception {
        int piconResourceId = R.drawable.picon_pbsamerica;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("PBS America")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_phoenixhd() throws Exception {
        int piconResourceId = R.drawable.picon_phoenixhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("PHOENIX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_planethd() throws Exception {
        int piconResourceId = R.drawable.picon_planethd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Planet HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_powerturk() throws Exception {
        int piconResourceId = R.drawable.picon_powerturk;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Power Türk")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_prosieben() throws Exception {
        int piconResourceId = R.drawable.picon_prosieben;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ProSieben")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_prosiebenfunhd() throws Exception {
        int piconResourceId = R.drawable.picon_prosiebenfunhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ProSieben FUN HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_prosiebenhd() throws Exception {
        int piconResourceId = R.drawable.picon_prosiebenhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ProSieben HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai1() throws Exception {
        int piconResourceId = R.drawable.picon_rai1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai2() throws Exception {
        int piconResourceId = R.drawable.picon_rai2;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai3() throws Exception {
        int piconResourceId = R.drawable.picon_rai3;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai 3")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rai4() throws Exception {
        int piconResourceId = R.drawable.picon_rai4;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai 4")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_raihd() throws Exception {
        int piconResourceId = R.drawable.picon_raihd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rainews24() throws Exception {
        int piconResourceId = R.drawable.picon_rainews24;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai News 24")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_raisport1() throws Exception {
        int piconResourceId = R.drawable.picon_raisport1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rai Sport 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rbbberlinhd() throws Exception {
        int piconResourceId = R.drawable.picon_rbbberlinhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("rbb Berlin HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_recordtvint() throws Exception {
        int piconResourceId = R.drawable.picon_recordtvint;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Record TV Int.")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rete4hd() throws Exception {
        int piconResourceId = R.drawable.picon_rete4hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Rete 4 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_romancetvhd() throws Exception {
        int piconResourceId = R.drawable.picon_romancetvhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Romance TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rsila1hd() throws Exception {
        int piconResourceId = R.drawable.picon_rsila1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RSI LA 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rsila2hd() throws Exception {
        int piconResourceId = R.drawable.picon_rsila2hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RSI LA 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtk1() throws Exception {
        int piconResourceId = R.drawable.picon_rtk1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTK 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtl2() throws Exception {
        int piconResourceId = R.drawable.picon_rtl2;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtl2hd() throws Exception {
        int piconResourceId = R.drawable.picon_rtl2hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL 2 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtl9hd() throws Exception {
        int piconResourceId = R.drawable.picon_rtl9hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL 9 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtlhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtlhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtllivinghd() throws Exception {
        int piconResourceId = R.drawable.picon_rtllivinghd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL Living HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtlnitrohd() throws Exception {
        int piconResourceId = R.drawable.picon_rtlnitrohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL Nitro HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtlpassionhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtlpassionhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTL Passion HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtrplaneta() throws Exception {
        int piconResourceId = R.drawable.picon_rtrplaneta;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTR Planeta")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtsdeuxhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtsdeuxhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTS Deux HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtssat() throws Exception {
        int piconResourceId = R.drawable.picon_rtssat;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTS Sat")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_rtsunhd() throws Exception {
        int piconResourceId = R.drawable.picon_rtsunhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("RTS Un HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_russiotoday() throws Exception {
        int piconResourceId = R.drawable.picon_russiatoday;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Russia Today")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sat1() throws Exception {
        int piconResourceId = R.drawable.picon_sat1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SAT.1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sat1hd() throws Exception {
        int piconResourceId = R.drawable.picon_sat1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SAT.1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_servustvhd() throws Exception {
        int piconResourceId = R.drawable.picon_servustvhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Servus TV HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_showturk() throws Exception {
        int piconResourceId = R.drawable.picon_showturk;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Show Türk")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sixxhd() throws Exception {
        int piconResourceId = R.drawable.picon_sixxhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Sixx HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_skybundesligahd1() throws Exception {
        int piconResourceId = R.drawable.picon_skybundesligahd1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Sky Bundesliga HD 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_skysport1() throws Exception {
        int piconResourceId = R.drawable.picon_skysport1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Sky Sport 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sport1hd() throws Exception {
        int piconResourceId = R.drawable.picon_sport1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SPORT1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sport1ushd() throws Exception {
        int piconResourceId = R.drawable.picon_sport1ushd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SPORT1 US HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_sportdigitalhd() throws Exception {
        int piconResourceId = R.drawable.picon_sportdigitalhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("sportdigital HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srf1hd() throws Exception {
        int piconResourceId = R.drawable.picon_srf1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SRF 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srfinfohd() throws Exception {
        int piconResourceId = R.drawable.picon_srfinfohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SRF info HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_srfzweihd() throws Exception {
        int piconResourceId = R.drawable.picon_srfzweihd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SRF zwei HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_superrtl() throws Exception {
        int piconResourceId = R.drawable.picon_superrtl;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Super RTL")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_superrtlhd() throws Exception {
        int piconResourceId = R.drawable.picon_superrtlhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Super RTL HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_swrbwhd() throws Exception {
        int piconResourceId = R.drawable.picon_swrbwhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("SWR BW HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tagesschau24hd() throws Exception {
        int piconResourceId = R.drawable.picon_tagesschau24hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("tagesschau24 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tcskysport2() throws Exception {
        int piconResourceId = R.drawable.picon_tcskysport2;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TC Sky Sport 2")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tcsport1() throws Exception {
        int piconResourceId = R.drawable.picon_tcsport1;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TC Sport 1")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tele5() throws Exception {
        int piconResourceId = R.drawable.picon_tele5;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Tele 5")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tf1hd() throws Exception {
        int piconResourceId = R.drawable.picon_tf1hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TF 1 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tgnthaiglobal() throws Exception {
        int piconResourceId = R.drawable.picon_tgnthaiglobal;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TGN Thai Global")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tgrthaber() throws Exception {
        int piconResourceId = R.drawable.picon_tgrthaber;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TGRT Haber")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tntcomedyhd() throws Exception {
        int piconResourceId = R.drawable.picon_tntcomedyhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TNT Comedy HD (TC)")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_travelchannelhd() throws Exception {
        int piconResourceId = R.drawable.picon_travelchannelhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("Travel Channel HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_trtturk() throws Exception {
        int piconResourceId = R.drawable.picon_trtturk;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TRT-TÜRK")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tv5monde() throws Exception {
        int piconResourceId = R.drawable.picon_tv5monde;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TV5MONDE")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_tvcg() throws Exception {
        int piconResourceId = R.drawable.picon_tvcg;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("TV CG")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_vh1classic() throws Exception {
        int piconResourceId = R.drawable.picon_vh1classic;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("VH1-Classic")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_vox() throws Exception {
        int piconResourceId = R.drawable.picon_vox;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("VOX")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_voxhd() throws Exception {
        int piconResourceId = R.drawable.picon_voxhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("VOX HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_w9hd() throws Exception {
        int piconResourceId = R.drawable.picon_w9hd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("W9 HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_wdrfernsehenhd() throws Exception {
        int piconResourceId = R.drawable.picon_wdrfernsehenhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("WDR Fernsehen HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_zdfhd() throws Exception {
        int piconResourceId = R.drawable.picon_zdfhd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ZDF HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_zdfinfohd() throws Exception {
        int piconResourceId = R.drawable.picon_zdfinfohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("ZDFinfo HD")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_zdfkultur() throws Exception {
        int piconResourceId = R.drawable.picon_zdfkultur;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("zdf.kultur")); // original e2servicename
    }

    @Test
    public void getPiconResourceId_zdfneohd() throws Exception {
        int piconResourceId = R.drawable.picon_zdfneohd;
        assertEquals(piconResourceId, PiconManager.getPiconResourceId("zdf_neo HD")); // original e2servicename
    }
}
