package com.example.taskcademia.Interfaces;

public interface LoginModel {

    public void userValidation(String user, String password, OnLoginFinishListener presenter);
}
