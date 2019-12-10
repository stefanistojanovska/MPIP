package com.wp.clients;

import com.wp.service.MoviesService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OmdbApiClient {
    private static Retrofit retrofit = null;

    private static Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.omdbapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static MoviesService getService() {
        return getRetrofit().create(MoviesService.class);
    }

}