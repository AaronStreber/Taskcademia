package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.taskcademia.Interfaces.LoginPresenter;
import com.example.taskcademia.R;

public class LoginView extends AppCompatActivity implements com.example.taskcademia.Interfaces.LoginView {
    private EditText user;
    private EditText pass;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        presenter = new com.example.taskcademia.Presenters.LoginPresenter(this);

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
        // Intent intent = new Intent();
    }

    @Override
    public void validation(View view) {
        presenter.validationUser(user.getText().toString(), pass.getText().toString());
    }
}