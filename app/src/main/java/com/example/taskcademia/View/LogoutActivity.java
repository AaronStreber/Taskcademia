package com.example.taskcademia.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskcademia.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logout);
    }


    public void logOut(View view) {
        FirebaseAuth.getInstance().signOut();
        onBackPressed();
        Intent intent = new Intent(this, LoginView.class);
        startActivity(intent);
    }
}