package com.example.whatsbuy.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.whatsbuy.R;
import com.example.whatsbuy.Adapter.UsersAdapter;
import com.example.whatsbuy.databinding.Activity2Binding;
import com.example.whatsbuy.Model.User;
import com.example.whatsbuy.Repository.UserRepository;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private final String TAG = "Activity2";
    private Activity2Binding layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_2);
        // substitui isto por isso
        layout = DataBindingUtil.setContentView(this, R.layout.activity_2);
        //User user1 = UserRepository.getInstance().getUserById(getIntent().getIntExtra("id", -1));
        User user1 = getIntent().getParcelableExtra("userObj");
        layout.setUser(user1);




    }

}
