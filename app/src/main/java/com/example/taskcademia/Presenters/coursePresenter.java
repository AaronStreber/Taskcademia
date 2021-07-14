package com.example.taskcademia.Presenters;

import android.widget.TextView;

import com.example.taskcademia.Models.courseModel;
import com.example.taskcademia.R;
import com.example.taskcademia.View.CourseAct;
import com.google.firebase.database.DatabaseReference;

public class coursePresenter {

    TextView course1, course2, course3, course4;
    CourseAct view;
    courseModel model;

    public coursePresenter(CourseAct view) {
        this.view = view;
        this.course1 = view.findViewById(R.id.course1);
        this.course2 = view.findViewById(R.id.course2);
        this.course3 = view.findViewById(R.id.course3);
        this.course4 = view.findViewById(R.id.course4);
        this.model = new courseModel();
    }

    public void setCourses(DatabaseReference database){
        this.model.getValue(course1, database.child("course1").child("name"));
        this.model.getValue(course2, database.child("course2").child("name"));
        this.model.getValue(course3, database.child("course3").child("name"));
        this.model.getValue(course4, database.child("course4").child("name"));
    }






}
