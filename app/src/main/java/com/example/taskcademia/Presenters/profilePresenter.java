package com.example.taskcademia.Presenters;

import android.widget.TextView;

import com.example.taskcademia.Models.profileModel;
import com.example.taskcademia.R;
import com.example.taskcademia.View.ProfileAct;
import com.google.firebase.database.DatabaseReference;

public class profilePresenter {

    TextView name, email, phone;
    profileModel model;
    ProfileAct view;

    public profilePresenter(ProfileAct view) {
        this.view = view;
        this.name = view.findViewById(R.id.profilename);
        this.email = view.findViewById(R.id.profile_email);
        this.phone = view.findViewById(R.id.profile_phone);
        this.model = new profileModel();
    }

    public void setInfo(DatabaseReference database){
        this.model.getValue(name, database.child("name"));
        this.model.getValue(email, database.child("email"));
        this.model.getValue(phone, database.child("phone"));


    }



}
