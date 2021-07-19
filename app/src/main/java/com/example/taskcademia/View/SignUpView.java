package com.example.taskcademia.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.taskcademia.Interfaces.SignUpPresenter;
import com.example.taskcademia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpView extends AppCompatActivity implements com.example.taskcademia.Interfaces.SignUpView {
    private EditText email;
    private EditText password1;
    private EditText password2;
    private SignUpPresenter signUpPresenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        email = findViewById(R.id.emailSignUp);
        password1 = findViewById(R.id.passwordSignUp1);
        password2 = findViewById(R.id.passwordSignUp2);
        signUpPresenter = new com.example.taskcademia.Presenters.SignUpPresenter((com.example.taskcademia.Interfaces.SignUpView) this);
        progressBar = findViewById(R.id.progressBar2);
        hideProgress();
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
    public void nameError() {

    }

    @Override
    public void passwordError() {

    }


    public void createUserAccount(View view) {
        signUpPresenter.userCreation(email.getText().toString(), password1.getText().toString(), password2.getText().toString());
    }

    public void goToLoginScreen(View view) {
        Intent intent = new Intent(this, LoginView.class);
        startActivity(intent);
    }
}