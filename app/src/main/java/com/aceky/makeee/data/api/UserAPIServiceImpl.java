package com.aceky.makeee.data.api;

import com.aceky.makeee.model.user.PostUser;
import com.aceky.makeee.model.user.SignedInUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPIServiceImpl {
    @POST("user/sign-up")
    Call<SignedInUser> signUpUser(@Body PostUser user);

    @POST("user/sign-in")
    Call<SignedInUser> signInUser(@Body PostUser user);
}
