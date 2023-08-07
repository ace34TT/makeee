package com.aceky.makeee.view.screens.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.aceky.makeee.data.repository.AuthRepository;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;

public class SignInViewModel extends ViewModel {
    AuthRepository repository = new AuthRepository();
    public void onSignInButtonClick (String email , String password ,ApiResponseCallback<SignedInUser> callback ) {
        repository.handleSignIn(email, password, callback);
    }
}
