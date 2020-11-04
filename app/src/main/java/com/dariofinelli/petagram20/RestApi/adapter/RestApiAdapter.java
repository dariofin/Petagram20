package com.dariofinelli.petagram20.RestApi.adapter;

import com.dariofinelli.petagram20.RestApi.deserializador.BioDeserializer;
import com.dariofinelli.petagram20.model.BioResponse;
import com.dariofinelli.petagram20.model.PetResponse;
import com.dariofinelli.petagram20.RestApi.ConstantsRestApi;
import com.dariofinelli.petagram20.RestApi.EndpointsAPI;
import com.dariofinelli.petagram20.RestApi.deserializador.PetDeserializador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsAPI stablishConnectionRestAPInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsAPI.class);
    }

    public Gson buildGsonDeserializeMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializador());
        return gsonBuilder.create();
    }

    public Gson builGsonDeserializerBioInfo() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BioResponse.class, new BioDeserializer());
        return gsonBuilder.create();
    }
}
