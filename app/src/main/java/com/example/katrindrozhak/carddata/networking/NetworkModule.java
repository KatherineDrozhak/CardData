package com.example.katrindrozhak.carddata.networking;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static NetworkService networkService;

    @Provides
    @Singleton
    static NetworkService getNetworkService() {
        if (networkService == null) {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            networkService = retrofit.create(NetworkService.class);
        }

        return networkService;
    }
}
