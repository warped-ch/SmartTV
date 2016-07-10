package org.dev.warped.smarttv;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andreas Wiedmer on 05.07.2016.
 */
public class PiconManager {

    private static final ArrayList<PiconResource> mPiconResources = new ArrayList<PiconResource>(
            Arrays.asList(
                    new PiconResource(R.drawable.picon_3plushd, "(?i)((3)(\\s*\\S*)((\\+)|(plus))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_3sathd, "(?i)(((drei)|(3))(\\s*\\S*)(sat)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((a&e)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_adultchannel, "(?i)((adult)(\\s*\\S*)(channel))"),
                    new PiconResource(R.drawable.picon_aljazeeraenglish, "(?i)((al)(\\s*\\S*)(jazeera)(\\s*\\S*)(english))"),
                    new PiconResource(R.drawable.picon_animalplanethd, "(?i)((animal)(\\s*\\S*)(planet)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_ardalpha, "(?i)((ard)(\\s*\\S*)(alpha))"),
                    new PiconResource(R.drawable.picon_atvavrupa, "(?i)((atv)(\\s*\\S*)(avrupa))"),
                    new PiconResource(R.drawable.picon_axnhd, "(?i)((axn)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((bbc)(\\s*\\S*)((four)|(4)))"), // TODO
                    new PiconResource(R.drawable.picon_bbcone, "(?i)((bbc)(\\s*\\S*)((one)|(1)))"),
                    new PiconResource(R.drawable.picon_bbconehd, "(?i)((bbc)(\\s*\\S*)((one)|(1))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((bbc)(\\s*\\S*)((three)|(3)))"), // TODO
                    new PiconResource(R.drawable.picon_bbctwohd, "(?i)((bbc)(\\s*\\S*)((two)|(2))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_bbcworldnews, "(?i)((bbc)(\\s*\\S*)(world)(\\s*\\S*)(news))"),
                    new PiconResource(R.drawable.picon_bibeltv, "(?i)((bibel)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_bloombergtv, "(?i)((bloomberg)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_bluehustler, "(?i)((blue)(\\s*\\S*)(hustler))"),
                    new PiconResource(R.drawable.picon_bn, "(?i)(bn)"),
                    new PiconResource(R.drawable.picon_bongustohd, "(?i)((bon)(\\s*\\S*)(gusto)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_brsudhd, "(?i)((br)(\\s*\\S*)((süd)|(sud)|(sued))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_bvntv, "(?i)((bvn)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_canale5hd, "(?i)((canale)(\\s*\\S*)(5)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_cartoonnetworkhdtc, "(?i)((cartoon)(\\s*\\S*)(network)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_cctv4, "(?i)((cctv)(\\s*\\S*)((4)|(four)))"),
                    new PiconResource(R.drawable.picon_cctvnews, "(?i)((cctv)(\\s*\\S*)(news))"),
                    new PiconResource(R.drawable.picon_channel5, "(?i)((channel)(\\s*\\S*)(5))"),
                    new PiconResource(R.drawable.picon_classicahd, "(?i)((classica)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_cnbc, "(?i)(cnbc)"),
                    new PiconResource(R.drawable.picon_cnnint, "(?i)((cnn)(\\s*\\S*)(int))\\W+"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((viva)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)(d4accl)"), // TODO
                    new PiconResource(R.drawable.picon_dmaxhd, "(?i)((dmax)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_dorceltv, "(?i)((dorcel)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_ehd, "(?i)((e!)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_e4, "(?i)(e4)"),
                    new PiconResource(R.drawable.picon_einsfestivalhd, "(?i)((einsfestival)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_einsplus, "(?i)(einsplus)"),
                    new PiconResource(R.drawable.picon_eurod, "(?i)((euro)(\\s*\\S*)(d))"),
                    new PiconResource(R.drawable.picon_euronews, "(?i)(euronews)"),
                    new PiconResource(R.drawable.picon_eurosport1, "(?i)((eurosport)(\\s*\\S*)(1))"),
                    new PiconResource(R.drawable.picon_eurosport2hd, "(?i)((eurosport)(\\s*\\S*)(2)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_eurostar, "(?i)(eurostar)"),
                    new PiconResource(R.drawable.picon_extremesports, "(?i)((extreme)(\\s*\\S*)(sports))"),
                    new PiconResource(R.drawable.picon_fashiontv, "(?i)((fashion)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_film4, "(?i)((film)(\\s*\\S*)(4))"),
                    new PiconResource(R.drawable.picon_foxhd, "(?i)((fox)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_france2hd, "(?i)((france)(\\s*\\S*)(2)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_france24, "(?i)((france)(\\s*\\S*)(24))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((france)(\\s*\\S*)(3)(\\s*\\S*)(alsace))"), // TODO
                    new PiconResource(R.drawable.picon_france4, "(?i)((france)(\\s*\\S*)(4))"),
                    new PiconResource(R.drawable.picon_france5, "(?i)((france)(\\s*\\S*)(5))"),
                    new PiconResource(R.drawable.picon_gotv, "(?i)(gotv)"),
                    new PiconResource(R.drawable.ic_tv, "(?i)(gtv)"), // TODO
                    new PiconResource(R.drawable.picon_gulli, "(?i)(gulli)"),
                    new PiconResource(R.drawable.picon_gutelaunetv, "(?i)((gute)(\\s*\\S*)(laune)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_hayatplus, "(?i)((hayat)(\\s*\\S*)(plus))"),
                    new PiconResource(R.drawable.picon_hrttv1, "(?i)((hrt)(\\s*\\S*)(tv)(\\s*\\S*)(1))"),
                    new PiconResource(R.drawable.picon_hse24, "(?i)(hse24)"),
                    new PiconResource(R.drawable.picon_hse24extra, "(?i)((hse24)(\\s*\\S*)(extra))"),
                    new PiconResource(R.drawable.picon_hustlertvhd, "(?i)((hustler)(\\s*\\S*)(tv)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_italia1hd, "(?i)((italia)(\\s*\\S*)(1)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_itv2, "(?i)((itv)(\\s*\\S*)(2))"),
                    new PiconResource(R.drawable.picon_itv3, "(?i)((itv)(\\s*\\S*)(3))"),
                    new PiconResource(R.drawable.picon_itv4, "(?i)((itv)(\\s*\\S*)(4))"),
                    new PiconResource(R.drawable.picon_jimjam, "(?i)(jimjam)"),
                    new PiconResource(R.drawable.picon_ktv, "(?i)((k)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_kabeleins, "(?i)((kabel)(\\s*\\S*)((1)|(eins)))"),
                    new PiconResource(R.drawable.picon_kabeleinsclassicshd, "(?i)((kabel)(\\s*\\S*)((1)|(eins))(\\s*\\S*)(classics)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_kabeleinshd, "(?i)((kabel)(\\s*\\S*)((1)|(eins))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((kanal)(\\s*\\S*)(7)(\\s*\\S*)(int))\\W+"), // TODO
                    new PiconResource(R.drawable.picon_kikahd, "(?i)((kika)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_kinowelthd, "(?i)((kinowelt)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_kurdsattv, "(?i)((kurdsat)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_la7, "(?i)((la)(\\s*\\S*)(7))"),
                    new PiconResource(R.drawable.picon_m6hd, "(?i)((m6)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_mediasetitalia, "(?i)((mediaset)(\\s*\\S*)(italia))"),
                    new PiconResource(R.drawable.picon_more4, "(?i)((more)(\\s*\\S*)(4))"),
                    new PiconResource(R.drawable.picon_motorstv, "(?i)((motors)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_mtvbrandnew, "(?i)((mtv)(\\s*\\S*)(brand)(\\s*\\S*)(new))"),
                    new PiconResource(R.drawable.picon_mtvdance, "(?i)((mtv)(\\s*\\S*)(dance))"),
                    new PiconResource(R.drawable.picon_mtvhd, "(?i)((mtv)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_mtvlivehd, "(?i)((mtv)(\\s*\\S*)(live)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_mtvmusic, "(?i)((mtv)(\\s*\\S*)(music))"),
                    new PiconResource(R.drawable.picon_ntvhd, "(?i)((n)(\\s*\\S*)(tv)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_n24hd, "(?i)((n)(\\s*\\S*)(24)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_natgeoi, "(?i)((nat)(\\s*\\S*)(geo)(\\s*\\S*)(i))"), // TODO: nat geo i?
                    new PiconResource(R.drawable.picon_natgeohd, "(?i)((nat)(\\s*\\S*)(geo)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_natgeowildhd, "(?i)((nat)(\\s*\\S*)(geo)(\\s*\\S*)(wild)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_nauticalchannelhd, "(?i)((nautical)(\\s*\\S*)(channel)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_ndrfsndshd, "(?i)((ndr)(\\s*\\S*)(fs)(\\s*\\S*)(nds)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_nickjr, "(?i)((nick)(\\s*\\S*)(jr)\\W+)"),
                    new PiconResource(R.drawable.picon_nickelodeonhd, "(?i)((nickelodeon)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_nt1, "(?i)(nt1)"),
                    new PiconResource(R.drawable.picon_ntvavrupa, "(?i)((ntv)(\\s*\\S*)(avrupa))"),
                    new PiconResource(R.drawable.picon_orf2, "(?i)((orf)(\\s*\\S*)((2)|(zwei)))"),
                    new PiconResource(R.drawable.picon_orf2hd, "(?i)((orf)(\\s*\\S*)((2)|(zwei))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_orfeinshd, "(?i)((orf)(\\s*\\S*)((1)|(eins))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_phoenixhd, "(?i)((phoenix)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((pink)(\\s*\\S*)(extra))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((pink)(\\s*\\S*)(plus))"), // TODO
                    new PiconResource(R.drawable.picon_planethd, "(?i)((planet)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_powerturk, "(?i)((power)(\\s*\\S*)((turk)|(türk)))"),
                    new PiconResource(R.drawable.picon_privatetv, "(?i)((private)(\\s*\\S*)(tv))"),
                    new PiconResource(R.drawable.picon_prosieben, "(?i)((pro)(\\s*\\S*)((7)|(sieben)))"),
                    new PiconResource(R.drawable.picon_prosiebenfunhd, "(?i)((pro)(\\s*\\S*)((7)|(sieben))(\\s*\\S*)(fun)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_prosiebenhd, "(?i)((pro)(\\s*\\S*)((7)|(sieben))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((plus)(\\s*\\S*)(8)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_rai1, "(?i)((rai)(\\s*\\S*)(1))"),
                    new PiconResource(R.drawable.picon_rai2, "(?i)((rai)(\\s*\\S*)(2))"),
                    new PiconResource(R.drawable.picon_rai3, "(?i)((rai)(\\s*\\S*)(3))"),
                    new PiconResource(R.drawable.picon_rai4, "(?i)((rai)(\\s*\\S*)(4))"),
                    new PiconResource(R.drawable.picon_rainews24, "(?i)((rai)(\\s*\\S*)(news)(\\s*\\S*)(24))"),
                    new PiconResource(R.drawable.picon_raisport1, "(?i)((rai)(\\s*\\S*)(sport)(\\s*\\S*)(1))"),
                    new PiconResource(R.drawable.picon_recordtvint, "(?i)((record)(\\s*\\S*)(tv)(\\s*\\S*)(int))\\W+"),
                    new PiconResource(R.drawable.picon_rete4hd, "(?i)((rete)(\\s*\\S*)(4)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_romancetvhd, "(?i)((romance)(\\s*\\S*)(tv)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rsila1, "(?i)((rsi)(\\s*\\S*)(la)(\\s*\\S*)(1))"),
                    new PiconResource(R.drawable.picon_rsila1hd, "(?i)((rsi)(\\s*\\S*)(la)(\\s*\\S*)(1)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rsila2, "(?i)((rsi)(\\s*\\S*)(la)(\\s*\\S*)(2))"),
                    new PiconResource(R.drawable.picon_rsila2hd, "(?i)((rsi)(\\s*\\S*)(la)(\\s*\\S*)(2)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtk1, "(?i)((rtk)(\\s*\\S*)(1))"),
                    new PiconResource(R.drawable.picon_rtl, "(?i)(rtl)"),
                    new PiconResource(R.drawable.picon_rtl2, "(?i)((rtl)(\\s*\\S*)(2))"),
                    new PiconResource(R.drawable.picon_rtl2hd, "(?i)((rtl)(\\s*\\S*)(2)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtlhd, "(?i)((rtl)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtllivinghd, "(?i)((rtl)(\\s*\\S*)(living)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtlnitrohd, "(?i)((rtl)(\\s*\\S*)(nitro)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtlpassionhd, "(?i)((rtl)(\\s*\\S*)(passion)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtrplaneta, "(?i)((rtr)(\\s*\\S*)(planeta))"),
                    new PiconResource(R.drawable.picon_rtsdeux, "(?i)((rts)(\\s*\\S*)((2)|(deux)))"),
                    new PiconResource(R.drawable.picon_rtsdeuxhd, "(?i)((rts)(\\s*\\S*)((2)|(deux))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_rtssat, "(?i)((rts)(\\s*\\S*)(sat))"),
                    new PiconResource(R.drawable.picon_rtsun, "(?i)((rts)(\\s*\\S*)((1)|(un)))"),
                    new PiconResource(R.drawable.picon_rtsunhd, "(?i)((rts)(\\s*\\S*)((1)|(un))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_russiatoday, "(?i)((russia)(\\s*\\S*)(today))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((s1)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_sat1, "(?i)((sat)(\\s*\\S*)((1)|(eins)))"),
                    new PiconResource(R.drawable.picon_sat1hd, "(?i)((sat)(\\s*\\S*)((1)|(eins))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)(schweiz5)"), // TODO
                    new PiconResource(R.drawable.picon_servustvhd, "(?i)((servus)(\\s*\\S*)(tv)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_showturk, "(?i)((show)(\\s*\\S*)((turk)|(türk)))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((sic)(\\s*\\S*)(int))\\W+"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((sic)(\\s*\\S*)(noticias))"), // TODO
                    new PiconResource(R.drawable.picon_sixxhd, "(?i)((sixx)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_sport1ushd, "(?i)((sport1)(\\s*\\S*)(us)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_sportdigitalhd, "(?i)((sportdigital)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_srf1, "(?i)((srf)(\\s*\\S*)((1)|(eins)))"),
                    new PiconResource(R.drawable.picon_srf1hd, "(?i)((srf)(\\s*\\S*)((1)|(eins))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_srfinfohd, "(?i)((srf)(\\s*\\S*)(info)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_srfzwei, "(?i)((srf)(\\s*\\S*)((2)|(zwei)))"),
                    new PiconResource(R.drawable.picon_srfzweihd, "(?i)((srf)(\\s*\\S*)((2)|(zwei))(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((star)(\\s*\\S*)(tv)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((stv)(\\s*\\S*)(avrupa))"), // TODO
                    new PiconResource(R.drawable.picon_superrtl, "(?i)((super)(\\s*\\S*)(rtl))"),
                    new PiconResource(R.drawable.picon_superrtlhd, "(?i)((super)(\\s*\\S*)(rtl)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_swrbwhd, "(?i)((swr)(\\s*\\S*)(bw)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_tagesschau24hd, "(?i)((tagesschau)(\\s*\\S*)(24)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((tele)(\\s*\\S*)((1)|(eins))(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_tele5, "(?i)((tele)(\\s*\\S*)(5))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((tele)(\\s*\\S*)((barn)|(baern)|(bärn))(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((tele)(\\s*\\S*)(d))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((tele)(\\s*\\S*)(m1)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((tele)(\\s*\\S*)(top)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((tele)(\\s*\\S*)(z))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((telebasel)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)(bielingue)"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((teleticino)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_tf1hd, "(?i)((tf)(\\s*\\S*)(1)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_tgnthaiglobal, "(?i)((tgn)(\\s*\\S*)(thai)(\\s*\\S*)(global))"),
                    new PiconResource(R.drawable.picon_tgrthaber, "(?i)((tgrt)(\\s*\\S*)(haber))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((tnt)(\\s*\\S*)(glitz)(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_travelchannelhd, "(?i)((travel)(\\s*\\S*)(channel)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_trtturk, "(?i)((trt)(\\s*\\S*)|((turk)|(türk)))"),
                    new PiconResource(R.drawable.picon_tv8, "(?i)((tv)(\\s*\\S*)(8))"),
                    new PiconResource(R.drawable.picon_tvcg, "(?i)((tv)(\\s*\\S*)(cg))"),
                    new PiconResource(R.drawable.ic_tv, "(?i)((tv)(\\s*\\S*)(globo)(\\s*\\S*)(int))\\W+"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)((tv)(\\s*\\S*)|((sudostschweiz)|(südostschweiz))(\\s*\\S*)(hd))"), // TODO
                    new PiconResource(R.drawable.picon_tv5monde, "(?i)(tv5monde)"),
                    new PiconResource(R.drawable.ic_tv, "(?i)(tvo)"), // TODO
                    new PiconResource(R.drawable.ic_tv, "(?i)(tvsh)"), // TODO
                    new PiconResource(R.drawable.picon_ukrainetoday, "(?i)((ukraine)(\\s*\\S*)(today))"),
                    new PiconResource(R.drawable.picon_vh1classic, "(?i)((vh1)(\\s*\\S*)(classic))"),
                    new PiconResource(R.drawable.picon_vox, "(?i)(vox)"),
                    new PiconResource(R.drawable.picon_voxhd, "(?i)((vox)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_wdrfernsehenhd, "(?i)((wdr)(\\s*\\S*)(hd))"),
                    new PiconResource(R.drawable.picon_zdfkultur, "(?i)((zdf)(\\s*\\S*)(kultur))"),
                    new PiconResource(R.drawable.picon_zdfneohd, "(?i)((zdf)(\\s*\\S*)(neo)(\\s*\\S*)(hd))")
            ));

    public static int getPicon(String channelName) {
        int piconResourceId = R.drawable.ic_tv;

        if (null != channelName && !channelName.isEmpty()) {
            for (PiconResource piconResource : mPiconResources) {
                if (channelName.matches(piconResource.getRegex())) {
                    piconResourceId = piconResource.getResourceId();
                    break;
                }
            }
        }

        return piconResourceId;
    }
}
