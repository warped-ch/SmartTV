package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2EventList;
import org.dev.warped.smarttv.model.E2ServiceList;
import org.dev.warped.smarttv.model.E2SimpleXmlResult;
import org.dev.warped.smarttv.model.E2Volume;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
public interface ApiServiceEnigma2 {
    @GET("web/getallservices")
    Call<E2ServiceList> getAllServices();

    @GET("web/getservices")
    Call<E2ServiceList> getServices();

    @GET("web/getservices")
    Call<E2ServiceList> getServices(@Query("sRef") String sRef);

    @GET("web/epgnow")
    Call<E2EventList> getEpgNow(@Query("bRef") String bRef);

    @GET("web/epgservice")
    Call<E2EventList> getEpgService(@Query("sRef") String sRef);

    @GET("web/vol")
    Call<E2Volume> getVolume(@Query("set") String set);

    @GET("web/zap")
    Call<E2SimpleXmlResult> getZap(@Query("sRef") String sRef);
}
