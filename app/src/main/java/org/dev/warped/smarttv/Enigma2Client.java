package org.dev.warped.smarttv;

import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
public class Enigma2Client {

    private static final String BASE_URL = "http://192.168.1.10/";
    private IApiServiceEnigma2 apiService;

    public Enigma2Client()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        apiService = retrofit.create(IApiServiceEnigma2.class);
    }

    public IApiServiceEnigma2 getApiService()
    {
        return apiService;
    }
}
