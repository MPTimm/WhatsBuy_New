package com.example.whatsbuy.Presenter;

import android.content.Intent;
import android.content.res.Resources;

import com.example.whatsbuy.R;
import com.example.whatsbuy.Model.User;
import com.example.whatsbuy.Repository.UserRepository;
import com.example.whatsbuy.systemService.UserServices;
import com.example.whatsbuy.View.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{

    private LoginPresenterContract.view activity;

    public LoginPresenter(LoginPresenterContract.view activity) {
        this.activity = activity;
    }

    @Override
    public void checkLogin(String login, String password) {
        //UserRepository repo  = UserRepository.getInstance(activity.getActivity(), null);
        //User u = repo.getUserByUserLogin(login);
        UserServices userServices = new UserServices(UserServices.REST_REPO, activity.getActivity());
        User u = userServices.getUserByUserLogin(login);

        if (u == null || ! u.getPassword().equals(password)) {
            activity.message("Usuário ou senha Inválido");
        } else {
            //u.setPassword("trocada");
            validLogin(u);
        }
    }

    private void validLogin(User user) {
        Intent intent = new Intent(activity.getActivity(), MainActivity.class);
        //intent.putExtra("userId", user.getId());
        intent.putExtra("userObj", user);
        activity.preferencesUserUpdate(user.getId());
        activity.getActivity().startActivity(intent);
    }

}
