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


}
