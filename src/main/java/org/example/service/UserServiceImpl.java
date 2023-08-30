package org.example.service;

import org.example.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final TimeService timeService;
    private Map<String, UserModel> userMap = new HashMap<>();


    public UserServiceImpl(TimeService timeService) {
        this.timeService = timeService;
        userMap.put("John", new UserModel("John", "Doe", 1234));
        userMap.put("Jane", new UserModel("Jane", "Doe", 4321));
    }

    public UserModel getUser(String userName) {
        return userMap.get(userName);
    }

    public void addUser(UserModel user) {

        user.setCreationTime(timeService.getCurrentTime("Madrid"));
        userMap.put(user.getFirstName(), user);
    }

    public void deleteUser(String userName) {
        userMap.remove(userName);
    }

}
