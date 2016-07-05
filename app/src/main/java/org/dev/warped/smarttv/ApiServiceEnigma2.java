package org.dev.warped.smarttv;

import org.dev.warped.smarttv.model.E2ServiceList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
public interface ApiServiceEnigma2 {
    @GET("web/getservices")
    Call<E2ServiceList> getServices();
    @GET("web/getservices")
    Call<E2ServiceList> getServices(@Query("sRef") String sRef);
}
