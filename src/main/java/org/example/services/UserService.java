package org.example.services;

import org.example.models.UserModel;

public interface UserService {
    UserModel getUser(String userName);

    void addUser(UserModel user);

    void deleteUser(String userName);
}
