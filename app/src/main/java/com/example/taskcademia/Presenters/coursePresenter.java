package com.example.taskcademia.Presenters;

import android.widget.TextView;

import com.example.taskcademia.Models.courseModel;
import com.example.taskcademia.R;
import com.example.taskcademia.View.CourseAct;
import com.google.firebase.database.DatabaseReference;

public class coursePresenter {
    /*
    *This class have an instance of the Course Activity to create reference of the textviews in order to set those to
    * values stored in the database.
     */

    TextView course1, course2, course3, course4; /* declare the textview variables  */
    CourseAct view; /* An instance of the Course Activity to initialize the text view variables */
    courseModel model; /* An instance of the Course model class to call the function getValue() */

    public coursePresenter(CourseAct view) {
        /* This method accepts as parameter an instance of the CourseAct Activity and initialize the
        *  textView variables. Also creates a new object of the CourseModel Class.
        */
        this.view = view;
        this.course1 = view.findViewById(R.id.course1);
        this.course2 = view.findViewById(R.id.course2);
        this.course3 = view.findViewById(R.id.course3);
        this.course4 = view.findViewById(R.id.course4);
        this.model = new courseModel();
    }

    public void setCourses(DatabaseReference database){
        /* this method accepts a database reference as parameter and use it to call the getValue
        * method from the courseModel class and use it to set the values in the database to the
        * textView.
        */
        this.model.getValue(course1, database.child("course1").child("name"));
        this.model.getValue(course2, database.child("course2").child("name"));
        this.model.getValue(course3, database.child("course3").child("name"));
        this.model.getValue(course4, database.child("course4").child("name"));
    }






}
