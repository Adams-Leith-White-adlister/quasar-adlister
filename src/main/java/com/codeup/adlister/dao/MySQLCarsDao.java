package com.codeup.adlister.dao;

import com.codeup.adlister.models.Car;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCarsDao implements Cars {
    private Connection connection = null;

    public MySQLCarsDao(Config config) {
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
    public List<Car> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars");
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all cars.", e);
        }
    }

    //write a method that will allow the logged in user to see all of their cars
    public List<Car> allById(int userId) throws SQLException{
        String query = "SELECT * FROM cars WHERE user_id = ?";
        PreparedStatement ps;
            ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();
            return createAdsFromResults(resultSet);
    }

    //write a method to view one car
    public Car oneCarById(int id) throws SQLException{
        String query = "SELECT * FROM cars WHERE id = ?";
        PreparedStatement ps;
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        return extractAd(resultSet);
    }

    //write a method to get car by id
    public Car findById(int id){
        Car car = null;
        String query = "SELECT * FROM cars WHERE id = ?";
        PreparedStatement ps;
        try{
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                car = new Car(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("year"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getDate("creation_date")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return car;
    }


    @Override
    public Long insert(Car car) {
        try {
            String sql =  "INSERT INTO cars(user_id, year, make, model, price, description) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, car.getUserId());
            statement.setInt(2, car.getYear());
            statement.setString(3, car.getMake());
            statement.setString(4, car.getModel());
            statement.setDouble(5, car.getPrice());
            statement.setString(6, car.getDescription());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new car.", e);
        }
    }


    private Car extractAd(ResultSet rs) throws SQLException {
        return new Car(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getInt("year"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getDate("creation_date")
        );
    }

    private List<Car> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Car> cars = new ArrayList<>();
        while (rs.next()) {
            cars.add(extractAd(rs));
        }
        return cars;
    }


}
