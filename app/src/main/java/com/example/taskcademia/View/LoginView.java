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
    /* This is the Main Activity. This activity is for the log in screen and sets everything
     * to start using the App
    */
    /* Here the variables are declared */
    private EditText user;
    private EditText pass;
    private ProgressBar progressBar;
    private LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        /* The variables are initialized , two edittext, for the user and for the password,
         * one for the progressbar and one instance of the presenter.
        */
        user = (EditText) findViewById(R.id.editTextTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        hideProgress();
        presenter = new com.example.taskcademia.Presenters.LoginPresenter(this);


    }

    @Override
    /* Make the progress bar visible */
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    /* Make the progress bar invisible */
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    /* Display the error for the user name field */
    public void errorUser() {
        user.setError("Incorrect username!");
    }

    @Override
    /* Display the error for the password field */
    public void errorPassword() {
        user.setError("Incorrect password!");
    }

    @Override
    public void navigateToHomeScreen() {
        /* This method creates and start a new activity of the home view and is called
         * when the registration was successful.
        */
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    @Override
    public void validation(View view) {
        /* This method calls the methods to validate the user information
         * and store that information in the local storage.
        */
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
        /* This Method start a new screen to Sign Up */
        Intent intent = new Intent(this, SignUpView.class);
        startActivity(intent);
    }

}