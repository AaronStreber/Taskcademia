package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.taskcademia.R;

public class home extends AppCompatActivity {
    /* this is the Activity for the Home view of the app. here we have the methods
     * to access the other activities of the App.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void launchCourses(View view){
        /* this method sets and launch the CourseAct Activity. */
        Intent intent = new Intent(this, CourseAct.class);
        startActivity(intent);
    }
    public void launchDueDates(View view){
        /* this method sets and launch the DueDate Activity. */
        Intent intent = new Intent(this, DueDate.class);
        startActivity(intent);
    }
    public void launchTeachers(View view){
        /* this method sets and launch the TeachersAct Activity. */
        Intent intent = new Intent(this, TeachersAct.class);
        startActivity(intent);
    }
    public void launchFood(View view){
        /* this method sets and launch the FoodAct Activity. */
        Intent intent = new Intent(this, FoodAct.class);
        startActivity(intent);
    }
    public void launchProfile(View view){
        /* this method sets and launch the ProfileAct Activity. */
        Intent intent = new Intent(this, ProfileAct.class);
        startActivity(intent);
    }

}