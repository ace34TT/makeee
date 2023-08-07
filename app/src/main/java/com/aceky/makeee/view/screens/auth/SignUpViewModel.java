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

    public void onSignUpButtonClick(String email, String password, String confirmPassword) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }
        if (password.equals(confirmPassword)) {
            return;
        }
        repository.handleSignUp(email, password, new ApiResponseCallback<SignedInUser>() {
            @Override
            public void onSuccess(SignedInUser response) {
                // Handle successful sign up
                showError.setValue(false);
                Log.d("sign-in" , "sign in success from view model ");
            }
            @Override
            public void onError(String errorMessage) {
                // Handle sign up error
                showError.setValue(true);
            }
        });
    }
}