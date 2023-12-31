package org.example.controllers;

import org.example.models.UserModel;
import org.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/getUser/{userName}")
    public ResponseEntity<UserModel> getUser(@PathVariable String userName) {
        return ResponseEntity.of(Optional.ofNullable(service.getUser(userName)));
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserModel user) {
        service.addUser(user);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/deleteUser/{userName}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userName) {
        service.deleteUser(userName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getHtml")
    public String getHtml() {
        return "<html><body><h1>The browser renders the HTML</h1></body></html>";
    }
}
