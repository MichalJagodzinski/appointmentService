package com.example.AppointmentService.repository;

import com.example.AppointmentService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT id, name, surname, login, password, email FROM user",
                BeanPropertyRowMapper.newInstance(User.class));
    }
}
