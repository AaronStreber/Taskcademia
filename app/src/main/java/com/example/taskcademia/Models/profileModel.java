package com.example.taskcademia.Models;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class profileModel {

    public void getValue(TextView tview, DatabaseReference database){
    database.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
            tview.setText(snapshot.getValue(String.class));
        }

        @Override
        public void onCancelled(@NonNull @NotNull DatabaseError error) {

        }
    });
}
}
