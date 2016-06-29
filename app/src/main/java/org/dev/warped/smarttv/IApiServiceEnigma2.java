package org.dev.warped.smarttv;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
public interface IApiServiceEnigma2 {
    @GET("web/about")
    Call<Enigma2Abouts> getAbout();

    //@GET("/web/getservices")
    //public List<Bouquet> getBouquets();
}
