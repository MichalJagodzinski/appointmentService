package com.example.AppointmentService.controller;

import com.example.AppointmentService.model.User;
import com.example.AppointmentService.repository.UserRepository;
import com.example.AppointmentService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping("getByUserId/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userRepository.getUserById(id);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        user = userService.login(user.getLogin(), user.getPassword());
        if (user != null) {
            return ResponseEntity.ok("User logged in successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login or password");
        }
    }
}
