package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taskcademia.Presenters.profilePresenter;
import com.example.taskcademia.Presenters.teachersPresenter;
import com.example.taskcademia.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileAct extends AppCompatActivity {

    public DatabaseReference database;
    profilePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        database = FirebaseDatabase.getInstance().getReference().child("data").child("profile");
        presenter = new profilePresenter(this);
        setTexts(presenter, database);
    }

    public void setTexts(profilePresenter presenter, DatabaseReference database) {
        presenter.setInfo(database);
    }
}