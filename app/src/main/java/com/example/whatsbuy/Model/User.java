package com.example.whatsbuy.Model;

import android.text.TextUtils;
import android.util.Patterns;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

public class User implements Parcelable{

    private int id;
    private String name;
    private String login;
    private String password;

}
