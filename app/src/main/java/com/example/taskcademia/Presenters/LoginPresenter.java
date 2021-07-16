package com.example.taskcademia.Presenters;

import android.view.View;
import android.widget.EditText;

import com.example.taskcademia.Interfaces.LoginView;
import com.example.taskcademia.Interfaces.OnLoginFinishListener;
import com.example.taskcademia.Models.LoginModel;

public class LoginPresenter implements com.example.taskcademia.Interfaces.LoginPresenter, OnLoginFinishListener {

    private com.example.taskcademia.Interfaces.LoginModel model;
    private final LoginView view;

    public LoginPresenter(LoginView view) {
        this.view = (LoginView) view;
        model = (com.example.taskcademia.Interfaces.LoginModel) new LoginModel();

    }

    @Override
    public void validationUser(String user, String password) {
        if (view != null){
            view.showProgress();
            model.userValidation(user, password, this);

        }
    }

    @Override
    public void nameError() {
        if (view != null) {
            view.hideProgress();
            view.errorUser();
        }
    }

    @Override
    public void passwordError() {
        if (view != null){
            view.hideProgress();
            view.errorPassword();
        }
    }

    @Override
    public void navigateSuccess() {
        view.hideProgress();
        view.navigateToHomeScreen();
    }
}
