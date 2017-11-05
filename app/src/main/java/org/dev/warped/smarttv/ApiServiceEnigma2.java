package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2Abouts;
import org.dev.warped.smarttv.model.E2EventList;
import org.dev.warped.smarttv.model.E2ServiceList;
import org.dev.warped.smarttv.model.E2SimpleXmlResult;
import org.dev.warped.smarttv.model.E2Volume;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface ApiServiceEnigma2 {
    @GET("web/about")
    Call<E2Abouts> getAbouts();

    @GET("web/getallservices")
    Call<E2ServiceList> getAllServices();

    @GET("web/getservices")
    Call<E2ServiceList> getServices();

    @GET("web/getservices")
    Call<E2ServiceList> getServices(@Query("sRef") String sRef);

    @GET("web/epgnow")
    Call<E2EventList> getEpgNow(@Query("bRef") String bRef);

    @GET("web/epgnownext")
    Call<E2EventList> getEpgNowNext(@Query("bRef") String bRef);

    @GET("web/epgservice")
    Call<E2EventList> getEpgService(@Query("sRef") String sRef);

    @GET("web/vol")
    Call<E2Volume> getVolume();

    @POST("web/vol")
    Call<E2Volume> postVolume(@Query("set") String set);

    @POST("web/zap")
    Call<E2SimpleXmlResult> postZap(@Query("sRef") String sRef);
}
