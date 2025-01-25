package org.cp.LLD.library.repository.impl;

import org.cp.LLD.library.models.User;
import org.cp.LLD.library.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository implements IRepository<User, String> {
    List<User> userList;

    public UserRepository(){
        userList = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        for(User _user: userList){
            if(_user.getUserId() == user.getUserId()){
                return;
            }
        }

        this.userList.add(user);
    }

    @Override
    public User getById(String userId) {
       List<User> _usrList = userList.stream()
               .filter(user -> Objects.equals(user.getUserId(), userId))
               .toList();
       if(_usrList.isEmpty()) return null;

       return _usrList.get(0);
    }

    @Override
    public void update(User data) {
        for(int i = 0; i < userList.size(); i++){
            if(Objects.equals(userList.get(i).getUserId(), data.getUserId())){
                userList.set(i, data);
                break;
            }
        }
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public void delete(User data) {
        userList.remove(data);
    }
}
