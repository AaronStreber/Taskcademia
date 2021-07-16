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

    public DatabaseReference database;
    profilePresenter presenter;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        database = FirebaseDatabase.getInstance().getReference().child("data").child("profile");
        presenter = new profilePresenter(this);
        try {
            setTexts(presenter, database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTexts(profilePresenter presenter, DatabaseReference database) throws IOException {
        presenter.setInfo(database, this);
    }

    public void logOut(View view) {
        Intent intent = new Intent(this, LogoutActivity.class);
        startActivity(intent);
    }

    public void showInfo(View view) throws FileNotFoundException {
        FileInputStream fin = null;
        info = findViewById(R.id.profile_info);
        try {
            fin = openFileInput("user_info.txt");
            System.out.println(fin);
            InputStreamReader inputStreamReader = new InputStreamReader(fin);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String textLine;
            StringBuilder stringBuilder = new StringBuilder();
            while((textLine = bufferedReader.readLine())!=null){
                stringBuilder.append(textLine);
            }
            info.setText(stringBuilder);
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
