package com.codeup.adlister.dao;

import com.codeup.adlister.models.Car;

import java.sql.SQLException;
import java.util.List;

public interface Cars {
    // get a list of all the ads
    List<Car> all();
    // insert a new car and return the new car's id
    Long insert(Car car);

    List<Car> allById(int id) throws SQLException;

    Object getCarById(int id) throws SQLException;

    List<Car> searchCars(String userSearch) throws SQLException;

	void updateCar(Car car) throws SQLException;

	void deleteCarById(int id) throws SQLException;
}
