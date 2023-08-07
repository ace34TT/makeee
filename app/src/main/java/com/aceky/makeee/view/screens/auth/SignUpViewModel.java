package com.aceky.makeee.view.screens.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aceky.makeee.data.repository.AuthRepository;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;

import java.util.Objects;

public class SignUpViewModel extends ViewModel {
    AuthRepository repository = new AuthRepository();
    private final MutableLiveData<Boolean> showError = new MutableLiveData<>();

    public LiveData<Boolean> getShowError() {
        return showError;
    }

    public void onSignUpButtonClick(String email, String password, String confirmPassword ,ApiResponseCallback<SignedInUser> callback) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }
        if (password.equals(confirmPassword)) {
            return;
        }
        repository.handleSignUp(email, password, callback);
    }
}