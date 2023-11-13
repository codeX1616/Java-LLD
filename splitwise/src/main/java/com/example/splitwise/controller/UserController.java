package com.example.splitwise.controller;

import com.example.splitwise.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserController {

    private List<User> userList;

    public UserController(){
        userList = new ArrayList<>();
    }

    //add user
    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String userID) {
        for (User user : userList) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return userList;
    }

}
