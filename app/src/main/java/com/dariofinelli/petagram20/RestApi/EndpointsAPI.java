package com.dariofinelli.petagram20.RestApi;

import com.dariofinelli.petagram20.model.BioResponse;
import com.dariofinelli.petagram20.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsAPI {

    @GET(ConstantsRestApi.URL_USER_MEDIA)
    Call<PetResponse> getRecentMedia();

    @GET(ConstantsRestApi.URL_USER_BIO)
    Call<BioResponse> getBioInfo();
}
