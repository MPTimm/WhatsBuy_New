package com.example.whatsbuy.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import com.example.whatsbuy.R;
import com.example.whatsbuy.Model.User;
import com.example.whatsbuy.Presenter.LoginPresenter;
import com.example.whatsbuy.Presenter.LoginPresenter2;
import com.example.whatsbuy.Presenter.LoginPresenterContract;
import com.example.whatsbuy.Repository.OnReadyListener;
import com.example.whatsbuy.Repository.UserRepository;
import com.example.whatsbuy.Repository.UserSQLRepository;

public class LoginActivity extends AppCompatActivity implements LoginPresenterContract.view{

    private LoginPresenterContract.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // obtendo o conjunto de SharedPeferences
        SharedPreferences preferences = getPreferences(0);
        boolean sqlUpdated = preferences.getBoolean("sqlUpdated", false);
        boolean logged = preferences.getBoolean("logged", false);
        int userId = preferences.getInt("userId", -1);

        Log.d("LoginActivity", "Preferences: "+sqlUpdated+", "+logged+ ", "+userId);

        if (userId >=0 && sqlUpdated) {
            User u = UserSQLRepository.getInstance(getActivity()).getUserById(userId);
            if (u != null) {
                ((TextView) findViewById(R.id.edLogin)).setText(u.getUserLogin());
                if (logged) {
                    Intent intent = new Intent(this, MainActivity.class);
                    //intent.putExtra("userId", user.getId());
                    intent.putExtra("userObj", u);

                    startActivity(intent);
                }
            }
        }


        Log.e("TAG", "onCreate: antes do getInstance" );

        // vou colocar os users vindos do endpoint para dentro do sql após a carga
        UserRepository.getInstance(this, new OnReadyListener() {
                    @Override
                    public void onReady() {
                        if (!sqlUpdated) {
                            List<User> users = UserRepository.getInstance().getUsers();
                            for (User u : users) {
                                UserSQLRepository.getInstance(getActivity()).addUser(u);
                            }
                            // Acessa preferencias compartilhadas
                            SharedPreferences preferences = getPreferences(0);
                            // pega o editor de preferencias
                            SharedPreferences.Editor editor = preferences.edit();
                            // gravando true na preferencia sqlUpdated
                            editor.putBoolean("sqlUpdated", true);
                            //confirmando a gravação nas preferencias
                            editor.commit();
                        }
                    }
                }
        );
        Log.e("TAG", "onCreate: depois do getInstance "+UserRepository.getInstance(this, null).getUsers().size());


        //this.presenter = new LoginPresenter(this);
        //trocando a presenter, com o mesmo contrato
        if (sqlUpdated) {
            this.presenter = new LoginPresenter(this);
        } else {
            this.presenter = (LoginPresenterContract.presenter) new LoginPresenter2(this);
        }
        View bt = findViewById(R.id.buttonLogin);
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.checkLogin(
                                ((EditText) findViewById(R.id.edLogin)).getText().toString(),
                                ((TextView) findViewById(R.id.edPassword)).getText().toString()
                        );
                    }
                }
        );

    }

    @Override
    public void message(String msg) {
        Snackbar.make(this,findViewById(R.id.edPassword),
                msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void preferencesUserUpdate(int userId) {
        SharedPreferences preferences = getPreferences(0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("userId", userId);
        editor.putBoolean("logged", true);
        editor.commit();
    }

}
