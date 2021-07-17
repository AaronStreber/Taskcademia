package com.example.taskcademia.Presenters;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.taskcademia.Models.teachersModel;
import com.example.taskcademia.R;
import com.example.taskcademia.View.TeachersAct;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class teachersPresenter {
    TextView Tname1, Tcourse1, Temail1, Tname2, Tcourse2, Temail2,
            Tname3, Tcourse3, Temail3, Tname4, Tcourse4, Temail4;
    teachersModel model;
    TeachersAct view;

    public teachersPresenter(TeachersAct view) {
        /* This method accepts as parameter an instance of the TeachersAct Activity and initialize the
         *  textView variables. Also creates a new object of the teachersModel Class.
         */
        this.view = view;
        Tname1 = view.findViewById(R.id.teacherName1);
        Tname2 = view.findViewById(R.id.teacherName2);
        Tname3 = view.findViewById(R.id.teacherName3);
        Tname4 = view.findViewById(R.id.teacherName4);
        Tcourse1 = view.findViewById(R.id.teacherCourse1);
        Tcourse2 = view.findViewById(R.id.teacherCourse2);
        Tcourse3 = view.findViewById(R.id.teacherCourse3);
        Tcourse4 = view.findViewById(R.id.teacherCourse4);
        Temail1 = view.findViewById(R.id.teacherEmail1);
        Temail2 = view.findViewById(R.id.teacherEmail2);
        Temail3 = view.findViewById(R.id.teacherEmail3);
        Temail4 = view.findViewById(R.id.teacherEmail4);
        this.model = new teachersModel();
    }

    public void setNames(DatabaseReference database){
        /* this method accepts a database reference as parameter and use it to call the getValue
         * method from the teachersModel class and use it to set the values in the database to the
         * textView.
         */
        /* The database reference access the node of where the teachers name is stored */
        this.model.getValue(Tname1, database.child("teacher01").child("name"));
        this.model.getValue(Tname2, database.child("teacher02").child("name"));
        this.model.getValue(Tname3, database.child("teacher03").child("name"));
        this.model.getValue(Tname4, database.child("teacher04").child("name"));
    }

    public void setCourses(DatabaseReference database){
        /* this method accepts a database reference as parameter and use it to call the getValue
         * method from the teachersModel class and use it to set the values in the database to the
         * textView.
         */
        /* The database reference access the node of where the teachers course is stored */
        this.model.getValue(Tcourse1, database.child("teacher01").child("course"));
        this.model.getValue(Tcourse2, database.child("teacher02").child("course"));
        this.model.getValue(Tcourse3, database.child("teacher03").child("course"));
        this.model.getValue(Tcourse4, database.child("teacher04").child("course"));
    }

    public void setEmail(DatabaseReference database){
        /* this method accepts a database reference as parameter and use it to call the getValue
         * method from the teachersModel class and use it to set the values in the database to the
         * textView.
         */
        /* The database reference access the node of where the teachers email is stored */
        this.model.getValue(Temail1, database.child("teacher01").child("email"));
        this.model.getValue(Temail2, database.child("teacher02").child("email"));
        this.model.getValue(Temail3, database.child("teacher03").child("email"));
        this.model.getValue(Temail4, database.child("teacher04").child("email"));
    }




}
