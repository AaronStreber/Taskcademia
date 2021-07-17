package com.example.taskcademia.Models;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class courseModel {
    /*
    *This have only one method that takes two arguments, a textview reference and a database reference,
    * and sets the info in the database to the textview
    *
     */

    public void getValue(TextView tview, DatabaseReference database){
        /* set a listener to the database to check for changes */
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                tview.setText(snapshot.getValue(String.class)); /* assign the value in the data base to the text view */
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }
}
