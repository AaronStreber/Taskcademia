package com.example.taskcademia.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.taskcademia.R;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void launchCourses(View view){

        Intent intent = new Intent(this, CourseAct.class);
        startActivity(intent);
    }
    public void launchCalendar(View view){

        Intent intent = new Intent(this, CalendarAct.class);
        startActivity(intent);
    }
    public void launchTeachers(View view){

        Intent intent = new Intent(this, TeachersAct.class);
        startActivity(intent);
    }
    public void launchFood(View view){

        Intent intent = new Intent(this, FoodAct.class);
        startActivity(intent);
    }
    public void launchProfile(View view){

        Intent intent = new Intent(this, ProfileAct.class);
        startActivity(intent);
    }

}