package com.dariofinelli.petagram20.firebase.adapter;

import com.dariofinelli.petagram20.firebase.RestApi.ConstantsFirebaseHeroku;
import com.dariofinelli.petagram20.firebase.RestApi.EndpointsFirebaseHeroku;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirebaseHerokuAdapter {

    public EndpointsFirebaseHeroku establercerConexionFirebaseHeroku() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsFirebaseHeroku.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(EndpointsFirebaseHeroku.class);
    }

    /*public EndpointsFirebaseHeroku establercerInstagramFirebaseHeroku() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsFirebaseHeroku.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(EndpointsFirebaseHeroku.class);
    }*/
}
