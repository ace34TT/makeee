package com.aceky.makeee.data.repository;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.aceky.makeee.data.api.ApiClient;
import com.aceky.makeee.data.api.UserAPIServiceImpl;
import com.aceky.makeee.model.user.PostUser;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthRepository {
    private UserAPIServiceImpl apiService;

    public AuthRepository() {
        Retrofit retrofit = ApiClient.getClient();
        apiService = retrofit.create(UserAPIServiceImpl.class);
    }

    public void handleSignIn(String email, String password, ApiResponseCallback<SignedInUser> callback) {
        Call<SignedInUser> call = apiService.signInUser(new PostUser(email, password));
        call.enqueue(new Callback<SignedInUser>() {
            @Override
            public void onResponse(Call<SignedInUser> call, Response<SignedInUser> response) {
                if (response.isSuccessful()) {
                    Log.d("sign-in" , "sign in success from repository");
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("error");
                }
            }

            @Override
            public void onFailure(Call<SignedInUser> call, Throwable t) {
                String errorMessage = "Error: " + t.getMessage();
                callback.onError(errorMessage);
            }
        });
    }

    public void handleSignUp(String email, String password, ApiResponseCallback<SignedInUser> callback) {
        Call<SignedInUser> call = apiService.signUpUser(new PostUser(email, password));
        call.enqueue(new Callback<SignedInUser>() {
            @Override
            public void onResponse(@NonNull Call<SignedInUser> call, @NonNull Response<SignedInUser> response) {
                if (response.isSuccessful()) {

                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Sign up failed");
                }
            }

            @Override
            public void onFailure(Call<SignedInUser> call, Throwable t) {
                String errorMessage = "Error: " + t.getMessage();
                callback.onError(errorMessage);
            }
        });
    }
}
