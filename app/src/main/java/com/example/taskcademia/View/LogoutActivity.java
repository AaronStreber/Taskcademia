package com.example.taskcademia.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskcademia.R;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutActivity extends AppCompatActivity {
    /* This is the Activity for the Log out screen */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logout);
    }


    public void logOut(View view) {
        /* This method connects with FireBase to close the session and launch a new Log In activity  */
        FirebaseAuth.getInstance().signOut();
        onBackPressed();
        Intent intent = new Intent(this, LoginView.class);
        startActivity(intent);
    }
}