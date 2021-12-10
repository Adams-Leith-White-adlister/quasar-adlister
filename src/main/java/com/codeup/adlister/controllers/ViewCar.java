package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "controllers.ViewCarServlet", urlPatterns = "/viewcar")
public class ViewCar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = DaoFactory.getCarsDao().findById((Integer) request.getSession().getAttribute("carId"));

        try {
            request.setAttribute("car", DaoFactory.getCarsDao().oneCarById((int) car.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("/WEB-INF/cars/viewcar.jsp").forward(request, response);

    }
}
