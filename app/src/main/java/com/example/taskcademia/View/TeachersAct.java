package com.example.taskcademia.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.taskcademia.Presenters.teachersPresenter;
import com.example.taskcademia.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TeachersAct extends AppCompatActivity {

    public DatabaseReference database;
    teachersPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teachers_layout);

        database = FirebaseDatabase.getInstance().getReference().child("data").child("teachers").child("data").child("teachers");
        presenter = new teachersPresenter(this);
        setTexts(presenter, database);

    }

    public void setTexts(teachersPresenter presenter, DatabaseReference database){
        presenter.setNames(database);
        presenter.setCourses(database);
        presenter.setEmail(database);
    }
}