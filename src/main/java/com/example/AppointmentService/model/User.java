package com.example.AppointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;

    public User(String name, String surname, String login, String password, String email) {
    }
}
