package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taskcademia.Presenters.coursePresenter;
import com.example.taskcademia.Presenters.teachersPresenter;
import com.example.taskcademia.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CourseAct extends AppCompatActivity {
    
    DatabaseReference database;
    coursePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_layout);

        database = FirebaseDatabase.getInstance().getReference().child("data").child("courses");
        presenter = new coursePresenter(this);
        setCourses(presenter, database);
    }

    public void setCourses(coursePresenter presenter, DatabaseReference database){
        presenter.setCourses(database);
    }
}