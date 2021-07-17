package com.example.taskcademia.Presenters;

import android.view.View;
import android.widget.TextView;

import com.example.taskcademia.Models.profileModel;
import com.example.taskcademia.R;
import com.example.taskcademia.View.ProfileAct;
import com.google.firebase.database.DatabaseReference;

public class profilePresenter {
    /* This class is the presenter for the profile Activity. this sets to the
     * text boxes the information that the model gets from the online database
    */
    TextView name, email, phone;
    profileModel model;
    ProfileAct view;

    public profilePresenter(ProfileAct view) {
        /* This method accepts as parameter an instance of the ProfileAct Activity and initialize the
         *  textView variables. Also creates a new object of the ProfileModel Class.
         */
        this.view = view;
        this.name = view.findViewById(R.id.profilename);
        this.email = view.findViewById(R.id.profile_email);
        this.phone = view.findViewById(R.id.profile_phone);
        this.model = new profileModel();
    }

    public void setInfo(DatabaseReference database, ProfileAct view ){
        /* this method accepts a database reference as parameter and use it to call the getValue
         * method from the profileModel class and use it to set the values in the database to the
         * textView.
         */
        this.model.getValue(name, database.child("name"));
        this.model.getValue(email, database.child("email"));
        this.model.getValue(phone, database.child("phone"));
    }
}
