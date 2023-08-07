package com.aceky.makeee.view.screens.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aceky.makeee.R;
import com.aceky.makeee.databinding.ActivitySignUpBinding;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;

public class SignUpActivity extends AppCompatActivity implements ApiResponseCallback {
    ActivitySignUpBinding binding;
    private SignUpViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        viewModel = new ViewModelProvider(this).get(SignUpViewModel.class);
        binding.btnSignUpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    viewModel.onSignUpButtonClick(binding.editTextTextEmailAddress.getText().toString(), binding.editTextTextPassword.getText().toString(), "confirm" , new ApiResponseCallback<SignedInUser>() {
                        @Override
                        public void onSuccess(SignedInUser response) {
                            // Handle successful sign up
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        @Override
                        public void onError(String errorMessage) {
                            // Handle sign up error
                            CharSequence text = "Sign-up , \n - password should be at least 8 characters \n - email already in use ";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(SignUpActivity.this /* MyActivity */, text, duration);
                            toast.show();
                        }
                    });
                } catch (IllegalArgumentException e) {
                    // Handle the exception here
                    String errorMessage = e.getMessage();
                    Toast.makeText(SignUpActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.btnGoBackSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(Object response) {

    }

    @Override
    public void onError(String errorMessage) {
        // Display the error message in the view
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}