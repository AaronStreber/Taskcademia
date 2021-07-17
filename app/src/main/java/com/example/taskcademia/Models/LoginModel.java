package com.example.taskcademia.Models;

import android.os.Handler;

import com.example.taskcademia.Interfaces.OnLoginFinishListener;
import com.example.taskcademia.View.ProfileAct;

public class LoginModel implements com.example.taskcademia.Interfaces.LoginModel {
    /*
    *This class contains the function to validate the log in information
    * provide by the user.
     */

    @Override
    public void userValidation(String user, String password, OnLoginFinishListener presenter) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!user.equals("") && !password.equals("")) {
                    presenter.navigateSuccess();/* if succedd call the method to navigate to the home screen */
                }
                else {
                    if (user.equals("")){
                        presenter.nameError();/* calls the method to show the error with the user name */
                    }
                    if (password.equals("")){
                        presenter.passwordError();/* calls the method to show the error with the password */
                    }
                }
            }
        }, 3000);
    }
}
