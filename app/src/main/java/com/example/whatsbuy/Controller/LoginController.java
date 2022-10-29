package com.example.whatsbuy.Controller;

import com.example.whatsbuy.Model.User;
import com.example.whatsbuy.View.ILoginView;

public class LoginController implements ILoginController{

    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String password) {

        User user = new User(email, password);
        int logincode = user.isValid();

        if(logincode == 0)
        {
            loginView.OnLoginError("Please Enter Email");

        }else if(logincode == 1)
        {
            loginView.OnLoginError("Please emter a valid email");

        }else if(logincode == 2)
        {
            loginView.OnLoginError("Please enter a password");

        }else if(logincode == 3)
        {
            loginView.OnLoginError("Password should be more than 6 characters");

        }else
        {
            loginView.OnLoginSuccess("Login Success");
        }

    }
}
