package com.aceky.makeee.view.screens.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aceky.makeee.R;
import com.aceky.makeee.databinding.ActivityLoginBinding;
import com.aceky.makeee.model.user.SignedInUser;
import com.aceky.makeee.util.ApiResponseCallback;
import com.aceky.makeee.view.screens.destination.DestinationActivity;
import com.aceky.makeee.view.screens.mainscreen.MainScreenActivity;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        com.aceky.makeee.databinding.ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SignInViewModel viewModel = new ViewModelProvider(this).get(SignInViewModel.class);

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        binding.btnSignInSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnSignInSubmit.setText("Loading....");

                viewModel.onSignInButtonClick(binding.editTextTextEmailAddress.getText().toString(), binding.editTextTextPassword.getText().toString(), new ApiResponseCallback<SignedInUser>() {
                    @Override
                    public void onSuccess(SignedInUser response) {
                        Log.d("login" , "success from view");
                        Intent intent=new Intent(LoginActivity.this, MainScreenActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    @Override
                    public void onError(String errorMessage) {
                        CharSequence text = "Wrong credentials";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(view.getContext() /* MyActivity */, text, duration);
                        toast.show();
                        binding.btnSignInSubmit.setText("Sign-in");
                    }
                });
            }
        });
    }
}