package org.dev.warped.smarttv;

import java.net.InetAddress;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Andreas Wiedmer on 29.06.2016.
 */
class Enigma2Client {

    private final ApiServiceEnigma2 mApiService;

    public Enigma2Client(InetAddress address)
    {
        String baseUrl = "http://" + address.getHostAddress() + "/";

        Retrofit retrofit;
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        } else {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
        }

        mApiService = retrofit.create(ApiServiceEnigma2.class);
    }

    public ApiServiceEnigma2 getApiService()
    {
        return mApiService;
    }
}
