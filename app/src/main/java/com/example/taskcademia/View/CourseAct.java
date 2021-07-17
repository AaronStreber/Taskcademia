package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.taskcademia.Presenters.coursePresenter;
import com.example.taskcademia.Presenters.teachersPresenter;
import com.example.taskcademia.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CourseAct extends AppCompatActivity {
    /* this is the Activity for the Course view of the app. Here we get the reference of the database and
     * call the methods to display the information
    */
     /* initialize the variables for the database reference and the presenter */
    DatabaseReference database;
    coursePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_layout);

        /* initialize the variables creating the reference and a new instance of the teachers Presenter Class.
         * Also,the setCourses method is called
        */
        database = FirebaseDatabase.getInstance().getReference().child("data").child("courses");
        presenter = new coursePresenter(this);
        setCourses(presenter, database);
    }

    public void setCourses(coursePresenter presenter, DatabaseReference database){
        /*This method takes the database reference and the instance of the presenter to show the
         * information on the screen
        */
        presenter.setCourses(database);
    }
}