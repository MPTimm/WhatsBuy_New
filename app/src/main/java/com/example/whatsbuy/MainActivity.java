package com.example.whatsbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.whatsbuy.Controller.ILoginController;
import com.example.whatsbuy.Controller.LoginController;
import com.example.whatsbuy.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText email, password;
    Button loginb;

    ILoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginController = new LoginController(this);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        loginb = (Button) findViewById(R.id.loginb);

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                loginController.OnLogin(email.getText().toString().trim(), password.getText().toString().trim());

            }
        });

    }

    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText((this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnLoginError(String message) {
        Toast.makeText((this, message, Toast.LENGTH_LONG).show();
    }
}