package com.aceky.makeee.view.screens.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aceky.makeee.R;
import com.aceky.makeee.databinding.ActivitySignUpBinding;
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
                    viewModel.onSignUpButtonClick(binding.editTextTextEmailAddress.getText().toString(), binding.editTextTextPassword.getText().toString(), "confirm");
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
                // Finish the current activity
                finish();
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