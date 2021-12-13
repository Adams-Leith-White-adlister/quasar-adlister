package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByUserId(int userId);
    void updateUser(User user) throws SQLException;
    void deleteUserById(int id) throws SQLException;
}
