package com.a15w.gameheadlines.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jpacino on 2016/9/6.
 */
public class HttpUtils {
    public static final String BASE_URL = "http://api.15w.com";
    private static HttpService httpService;
    public static HttpService init (){
        if (httpService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            httpService =retrofit.create(HttpService.class);
        }
        return httpService;
    }
}
