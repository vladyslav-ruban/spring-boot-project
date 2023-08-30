package org.example.controllers;

import org.example.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class UserController {

    HashMap<String, UserModel> userMap = new HashMap<>();

    public UserController() {
        userMap.put("John", new UserModel("John", "Doe", 1234));
        userMap.put("Jane", new UserModel("Jane", "Doe", 4321));
    }

    @GetMapping("/getUser/{userName}")
    public ResponseEntity<UserModel> getUser(@PathVariable String userName) {
        if (userMap.containsKey(userName)) {
            return ResponseEntity.of(Optional.of(userMap.get(userName)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserModel user) {
        userMap.put(user.getFirstName(), user);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/deleteUser/{userName}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userName) {
        userMap.remove(userName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getHtml")
    public String getHtml() {
        return "<html><body><h1>The browser renders the HTML</h1></body></html>";
    }
}
