package com.example.whatsbuy.Presenter;

import android.app.Activity;
import android.content.Context;

import  com.example.whatsbuy.Model.User;

public class LoginPresenterContract {
    public interface view {
        public void message(String msg);
        public Activity getActivity();
        public void preferencesUserUpdate(int userId);
    }

    public interface presenter {
        public void checkLogin(String login, String password);
        //public void validLogin(User user);

    }
}
