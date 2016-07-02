package org.dev.warped.smarttv;

import java.net.InetAddress;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
public class Enigma2Client {

    private final String mBaseUrl;
    private final ApiServiceEnigma2 mApiService;

    public Enigma2Client(InetAddress address)
    {
        mBaseUrl = "http://" + address.getHostAddress() + "/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        mApiService = retrofit.create(ApiServiceEnigma2.class);
    }

    public ApiServiceEnigma2 getApiService()
    {
        return mApiService;
    }
}
