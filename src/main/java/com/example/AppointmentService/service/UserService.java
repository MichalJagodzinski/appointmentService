package com.example.AppointmentService.service;

import com.example.AppointmentService.model.User;
import com.example.AppointmentService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

    public User login(String login, String password) {
        return userRepository.findLoginAndPassword(login, password);
    }
}
