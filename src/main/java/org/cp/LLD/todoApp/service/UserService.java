package org.cp.LLD.todoApp.service;

import org.cp.LLD.todoApp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users;

    public UserService(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(int userId){
        for(User user: users){
            if(user.getId() == userId) return user;
        }

        return null;
    }
}
