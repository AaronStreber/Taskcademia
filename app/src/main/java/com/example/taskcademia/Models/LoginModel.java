package com.example.taskcademia.Models;

import android.os.Handler;

import com.example.taskcademia.Interfaces.LoginView;
import com.example.taskcademia.Interfaces.OnLoginFinishListener;

public class LoginModel implements com.example.taskcademia.Interfaces.LoginModel {
    @Override
    public void userValidation(String user, String password, OnLoginFinishListener presenter) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!user.equals("") && !password.equals("")) {
                    presenter.navigateSuccess();
                }
                else {
                    if (user.equals("")){
                        presenter.nameError();
                    }
                    if (password.equals("")){
                        presenter.passwordError();
                    }
                }
            }
        }, 3000);
    }
}
