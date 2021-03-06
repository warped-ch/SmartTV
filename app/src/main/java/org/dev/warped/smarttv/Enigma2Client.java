package org.dev.warped.smarttv;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

class Enigma2Client {

    private final ApiServiceEnigma2 mApiService;

    public Enigma2Client(String address) {
        String baseUrl = "http://" + address + "/";

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

    public ApiServiceEnigma2 getApiService() {
        return mApiService;
    }
}
