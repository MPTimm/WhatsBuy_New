package com.example.whatsbuy.Presenter;

import android.content.Intent;

import com.example.whatsbuy.Model.User;
import com.example.whatsbuy.Repository.UserRepository;
import com.example.whatsbuy.View.Activity2;
import com.example.whatsbuy.View.MainActivity;

public class LoginPresenter2 {

    private LoginPresenterContract.view view;

    public LoginPresenter2(LoginPresenterContract.view view) {
        this.view = view;
    }


    public void checkLogin(String login, String password) {
        UserRepository repo  = UserRepository.getInstance(view.getActivity(), null);
        User u = repo.getUserByUserLogin(login);
        if (u == null || ! u.getPassword().equals(password)) {
            view.message("Usuário ou senha Inválido");
        } else {
            u.setPassword("trocada");
            validLogin(u);
        }
    }

    private void validLogin(User user) {
        Intent intent = new Intent(view.getActivity(), Activity2.class);
        //intent.putExtra("userId", user.getId());
        intent.putExtra("userObj", user);
        view.getActivity().startActivity(intent);
    }
}
