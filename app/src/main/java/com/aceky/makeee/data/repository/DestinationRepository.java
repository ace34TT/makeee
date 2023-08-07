package com.aceky.makeee.data.repository;

import android.util.Log;

import com.aceky.makeee.data.api.ApiClient;
import com.aceky.makeee.data.api.DestinationAPIServiceImpl;
import com.aceky.makeee.data.api.UserAPIServiceImpl;
import com.aceky.makeee.model.destination.Province;
import com.aceky.makeee.model.user.PostUser;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DestinationRepository {
    private DestinationAPIServiceImpl apiService;
    public DestinationRepository() {
        Retrofit retrofit = ApiClient.getClient();
        apiService = retrofit.create(DestinationAPIServiceImpl.class);
    }

    public void handleFindProvince (String provinceName  , ApiResponseCallback<Province> callback){
        Call<Province> call = apiService.getProvince(provinceName);
        call.enqueue(new Callback<Province>() {
            @Override
            public void onResponse(Call<Province> call, Response<Province> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("error");
                }
            }

            @Override
            public void onFailure(Call<Province> call, Throwable t) {

            }

        });
    }

}
