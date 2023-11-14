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

    /**
     * Controller method to add user
     * @param user {@link User}
     */
    public void addUser(User user) {
        userList.add(user);
    }

    /**
     * Controller method to get User
     * @param userID {@link String}
     * @return {@link User}
     */
    public User getUser(String userID) {
        for (User user : userList) {
            if (user.getUserId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Controller method to get all users
     * @return {@link List<User>}
     */
    public List<User> getAllUsers(){
        return userList;
    }

}
