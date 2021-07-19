package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.taskcademia.Presenters.profilePresenter;
import com.example.taskcademia.Presenters.teachersPresenter;
import com.example.taskcademia.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProfileAct extends AppCompatActivity {
    /* This is the Activity for the Profile view. Here we can see the user information stored in
    * the local storage and close the session to go back to the log in screen. */

    /* Here the Variables are declare. A database reference, a profilePresenter and a TextView */
    public DatabaseReference database;
    profilePresenter presenter;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        /*the database and the presenter are initialized , also the setText function is called */
        database = FirebaseDatabase.getInstance().getReference().child("data").child("profile");
        presenter = new profilePresenter(this);
        try {
            setTexts(presenter, database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTexts(profilePresenter presenter, DatabaseReference database) throws IOException {
        /* This method display the information we need in the profile view */
        presenter.setInfo(database, this);
    }

    public void logOut(View view) {
        /* This method creates and launch a new log out activity */
        Intent intent = new Intent(this, LogoutActivity.class);
        startActivity(intent);
    }

    public void showInfo(View view) throws FileNotFoundException{
        /*This method gets the information fro the local storage and display it to the user */
        FileInputStream fin = null; /* declare and initialize a new FileinputStream */
        info = findViewById(R.id.profile_info); /* Initialize the EditText */
        try {
            fin = openFileInput("user_info.txt");   /* give the variable fin it's actual value */
            InputStreamReader inputStreamReader = new InputStreamReader(fin); /* creates a new inputStreamReader */
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); /* creates a new BUfferReader to read the the iputStreamReader */
            String textLine; /* String  variable to store the lines the bufferReader gets */
            StringBuilder stringBuilder = new StringBuilder(); /* creates a new StringBuilder */
            while((textLine = bufferedReader.readLine())!=null){
                /* while the file stillhave lines left to read the String builder appends every line in te file */
                stringBuilder.append(textLine);
            }
            info.setText(stringBuilder); /* set the info in the file to the text View */
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
