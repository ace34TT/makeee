package com.aceky.makeee.view.screens.auth;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModel;

public class AuthViewModel extends ViewModel {
    String email = "";
    String password = "";

    public void onLoginButtonClick() {
        if (email.isEmpty() || password.isEmpty()) {
            //
            return;
        }
    }

    public void onSignUpButtonClick(String email, String password, String confirmPassword) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Log.d("Sign up btn", " error ");
            return;
        }
        if (password.equals(confirmPassword)) {
            Log.d("Sign up btn", " error ");
            return;}
        Log.d("Sign up btn", "sign up success");
    }
}