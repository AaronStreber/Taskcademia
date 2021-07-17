package com.example.taskcademia.Presenters;

import android.view.View;
import android.widget.EditText;

import com.example.taskcademia.Interfaces.LoginView;
import com.example.taskcademia.Interfaces.OnLoginFinishListener;
import com.example.taskcademia.Models.LoginModel;

public class LoginPresenter implements com.example.taskcademia.Interfaces.LoginPresenter, OnLoginFinishListener {
    /* This class contains all the methods to update the Login view and the Login Model
    * and serves as a bridge between those.
    */

    /* Declaration of the variables  */
    private final com.example.taskcademia.Interfaces.LoginModel model;
    private final LoginView view;

    public LoginPresenter(LoginView view) {
        /* The constructor initialize the variables, accepts as argument an instance
        * of the LoginView Activity.
        */
        this.view = (LoginView) view;
        model = (com.example.taskcademia.Interfaces.LoginModel) new LoginModel();

    }

    @Override
    public void validationUser(String user, String password) {
        /* this method accepts two string as parameters and use them yo call the userValidation method
        * from the model. Also, when called access the method showProgress that access
        * the progress bar and display it.
        */
        if (view != null){
            view.showProgress();
            model.userValidation(user, password, this);

        }
    }

    @Override
    public void nameError() {
        /* This method sets the user name error, and is called when there is an error with the user name */
        if (view != null) {
            view.hideProgress();
            view.errorUser();
        }
    }

    @Override
    public void passwordError() {
        /* This method sets the password error, and is called when there is an
         * error with the password.
        */
        if (view != null){
            view.hideProgress();
            view.errorPassword();
        }
    }

    @Override
    public void navigateSuccess() {
        /* When everything is correct this method is called. Calls the methods from the View
         * to hide the progress bar and to create the new intent for the home Screen view
        */
        view.hideProgress();
        view.navigateToHomeScreen();
    }
}
