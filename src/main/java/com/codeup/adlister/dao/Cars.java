package com.codeup.adlister.dao;

import com.codeup.adlister.models.Car;

import java.sql.SQLException;
import java.util.List;

public interface Cars {
    List<Car> all();
    Long insert(Car car);
    List<Car> allByUserId(int id) throws SQLException;
    Object getCarById(int id) throws SQLException;
    List<Car> searchCars(String userSearch) throws SQLException;
	void updateCar(Car car) throws SQLException;
	void deleteCarById(int id) throws SQLException;
}
