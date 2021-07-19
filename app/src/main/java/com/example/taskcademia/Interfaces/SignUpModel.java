package com.example.taskcademia.Interfaces;

public interface SignUpModel {
    public void userCreation(String user, String password1, String password2, OnSignupFinishListener presenter);
}
