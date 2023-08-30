package org.example.service;

import org.example.model.UserModel;

public interface UserService {
    UserModel getUser(String userName);

    void addUser(UserModel user);

    void deleteUser(String userName);
}
