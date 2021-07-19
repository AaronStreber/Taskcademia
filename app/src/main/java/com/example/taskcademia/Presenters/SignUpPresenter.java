package com.example.taskcademia.Presenters;

import com.example.taskcademia.Interfaces.LoginView;
import com.example.taskcademia.Interfaces.OnSignupFinishListener;
import com.example.taskcademia.Interfaces.SignUpModel;
import com.example.taskcademia.Interfaces.SignUpView;
import com.example.taskcademia.Models.LoginModel;

public class SignUpPresenter implements com.example.taskcademia.Interfaces.SignUpPresenter, OnSignupFinishListener {

    private SignUpModel signUpModel;
    private final SignUpView signUpView;

    public SignUpPresenter(SignUpView view) {
        this.signUpView = view;
        signUpModel = new com.example.taskcademia.Models.SignUpModel();
    }

    @Override
    public void nameError() {

    }

    @Override
    public void passwordError() {

    }

    @Override
    public void userCreation(String user, String password1, String password2) {
        if (signUpView != null){
            signUpView.showProgress();
            signUpModel.userCreation(user, password1, password2, this);
        }
    }
}
