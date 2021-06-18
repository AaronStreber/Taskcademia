package com.example.taskcademia.Interfaces;

import android.view.View;

public interface LoginView {

    public void showProgress();

    public void hideProgress ();

    public void errorUser ();

    public void errorPassword();

    public void navigateToHomeScreen();

    public void validation(View view);
}
