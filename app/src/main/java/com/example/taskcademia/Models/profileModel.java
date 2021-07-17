package com.example.taskcademia.Models;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.taskcademia.View.ProfileAct;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import static android.content.Context.MODE_PRIVATE;

public class profileModel {
    /*
    *This have only one method that takes two arguments, a textview reference and a database reference,
    * and sets the info in the database to the textview.
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
