package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.taskcademia.Interfaces.LoginPresenter;
import com.example.taskcademia.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginView extends AppCompatActivity implements com.example.taskcademia.Interfaces.LoginView {
    private EditText user;
    private EditText pass;
    private ProgressBar progressBar;
    private LoginPresenter presenter;
    private FirebaseAuth mAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Taskcademia);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mAuth = FirebaseAuth.getInstance();
        user = findViewById(R.id.signUpEmail);
        pass = findViewById(R.id.signUpPassword);
        progressBar = findViewById(R.id.progressBar);
        hideProgress();
        presenter = new com.example.taskcademia.Presenters.LoginPresenter(this);
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void errorUser() {
        user.setError("Incorrect username!");
    }

    @Override
    public void errorPassword() {
        user.setError("Incorrect password!");
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    @Override
    public void validation(View view) {
        presenter.validationUser(user.getText().toString(), pass.getText().toString());
    }

    public void signUpUser(View view) {
        Intent intent = new Intent(this, SignUpView.class);
        startActivity(intent);
    }
}