package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config){  //because we added config as a parameter here, it also needs to be a parameter in the DaoFactory when we instantiate
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = new User(    //instantiate the new User Object
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;  //return the user object from user User = new User(...)
    }

    @Override
    public Long insert(User user) {

        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)"; //not sure if it matters if this is inside or outside of try statement

        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet generatedIdResultSet = stmt.getGeneratedKeys();
            generatedIdResultSet.next();
            return generatedIdResultSet.getLong(1);

        } catch (SQLException e){
            throw new RuntimeException("Error creating a new user", e);
        }
    }
}
