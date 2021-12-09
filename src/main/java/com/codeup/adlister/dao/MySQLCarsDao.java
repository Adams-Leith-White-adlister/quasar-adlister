package com.codeup.adlister.dao;

import com.codeup.adlister.models.Car;
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
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Car car) {
        try {
            String sql =  "INSERT INTO cars(user_id, year, make, model, price, description) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, car.getUserId());
            statement.setInt(2, car.getYear());
            statement.setString(3, car.getMake());
            statement.setString(4, car.getModel());
            statement.setDouble(5, car.getPrice());
            statement.setString(6, car.getDescription());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
//            Statement stmt = connection.createStatement();
//            stmt.executeUpdate(createInsertQuery(car), Statement.RETURN_GENERATED_KEYS);
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new car.", e);
        }
    }

//    private String createInsertQuery(Car car) {
//        return "INSERT INTO ads(user_id, year, make, model, price, description) VALUES "
//                + "(" + car.getUserId() + ", "
//                + "'" + car.getYear() + "', "
//                + "'" + car.getMake() + "', "
//                + "'" + car.getModel() + "', "
//                + "'" + car.getPrice() + "', "
//                + "'" + car.getDescription() + "')";
//    }

    private Car extractAd(ResultSet rs) throws SQLException {
        return new Car(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getInt("year"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getDouble("price"),
                rs.getString("description"),
                rs.getDate("creationDate")
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
