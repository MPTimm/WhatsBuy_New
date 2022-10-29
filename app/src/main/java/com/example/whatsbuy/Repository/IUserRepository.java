package com.example.whatsbuy.Repository;

import java.util.List;

import com.example.whatsbuy.Model.User;

public interface IUserRepository {
    public List<User> getUsers();
    public User getUserById(int id);
    public User getUserByUserLogin(String login);
    public List<User> getUsersByName(String name);
    public User addUser(User user);
    public User updateUser(User user) ;
    public User removeUser(User user);
}
