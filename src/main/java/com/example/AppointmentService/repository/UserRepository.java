package com.example.AppointmentService.repository;

import com.example.AppointmentService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT id, name, surname, email FROM user",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getUserById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, name, surname FROM user WHERE " +
                "id = ?", BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public int save(User user) {
        return jdbcTemplate.
                update("INSERT INTO user (name, surname, login, password, email) VALUES (?, ?, ?, ?, ?)",
                        user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getEmail());
    }

    public User findLoginAndPassword(String login, String password) {
        try {
            return jdbcTemplate.
                    queryForObject("SELECT * FROM user WHERE login = ? AND password = ?",
                            new Object[]{login, password}, (rs, rowNum) ->
                                    new User(
                                            rs.getInt("id"),
                                            rs.getString("name"),
                                            rs.getString("surname"),
                                            rs.getString("login"),
                                            rs.getString("password"),
                                            rs.getString("email")
                                    ));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
