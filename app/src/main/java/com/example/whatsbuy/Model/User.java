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

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        login = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(login);
        parcel.writeString(password);
    }
}
