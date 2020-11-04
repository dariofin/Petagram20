package com.dariofinelli.petagram20.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.dariofinelli.petagram20.MainActivity;
import com.dariofinelli.petagram20.fragment.IProfileFragmentView;
import com.dariofinelli.petagram20.model.BioResponse;
import com.dariofinelli.petagram20.model.PetResponse;
import com.dariofinelli.petagram20.pojo.BioItem;
import com.dariofinelli.petagram20.pojo.ProfileItem;
import com.dariofinelli.petagram20.RestApi.EndpointsAPI;
import com.dariofinelli.petagram20.RestApi.adapter.RestApiAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragmentPresenter implements IProfileFragmentPresenter {

    private final IProfileFragmentView iProfileFragmentView;
    private final Context context;
    private ArrayList<ProfileItem> profileItems;
    private BioItem bioItem;

    public ProfileFragmentPresenter(IProfileFragmentView iProfileFragmentView, Context context) {
        this.iProfileFragmentView = iProfileFragmentView;
        this.context = context;
        obtenerMediosRecientes();
        obtenerInformacionUsuario();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.buildGsonDeserializeMediaRecent();
        EndpointsAPI endpointsAPI = restApiAdapter.stablishConnectionRestAPInstagram(gsonMediaRecent);
        Call<PetResponse> petResponseCall = endpointsAPI.getRecentMedia();
        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                profileItems = petResponse.getProfileItems();
                mostrarContactosRecyclerView();

                MainActivity.profileItems = profileItems;
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión con servidor", Toast.LENGTH_LONG).show();
                Log.e("Connection failed", t.toString());
            }
        });
    }

    @Override
    public void obtenerInformacionUsuario() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonBioInfo = restApiAdapter.builGsonDeserializerBioInfo();
        EndpointsAPI endpointsAPI = restApiAdapter.stablishConnectionRestAPInstagram(gsonBioInfo);
        Call<BioResponse> bioResponseCall = endpointsAPI.getBioInfo();
        bioResponseCall.enqueue(new Callback<BioResponse>() {
            @Override
            public void onResponse(Call<BioResponse> call, Response<BioResponse> response) {
                BioResponse bioResponse = response.body();
                bioItem = bioResponse.getBioItem();
                iProfileFragmentView.showProfile(bioItem);
            }

            @Override
            public void onFailure(Call<BioResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión con servidor", Toast.LENGTH_LONG).show();
                Log.e("Connection failed", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRecyclerView() {
        iProfileFragmentView.initializeAdapter(iProfileFragmentView.createAdapter(profileItems));
        iProfileFragmentView.generateGridLayout();
    }
}
