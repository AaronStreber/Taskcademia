package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.taskcademia.Interfaces.LoginPresenter;
import com.example.taskcademia.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginView extends AppCompatActivity implements com.example.taskcademia.Interfaces.LoginView {
    private EditText user;
    private EditText pass;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        hideProgress();
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
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    @Override
    public void validation(View view) {
        String userId = user.getText().toString();
        String password = pass.getText().toString();
        presenter.validationUser(userId, password);
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("user_info.txt", MODE_PRIVATE);
            assert fos != null;
            fos.write(userId.getBytes());
            fos.write(" - ".getBytes());
            fos.write(password.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void signUp(View view){
        Intent intent = new Intent(this, SignUpView.class);
        startActivity(intent);
    }

}