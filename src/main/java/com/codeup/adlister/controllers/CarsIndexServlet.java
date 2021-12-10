package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/cars")
public class CarsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cars", DaoFactory.getCarsDao().all());
        request.getRequestDispatcher("/WEB-INF/cars/index.jsp").forward(request, response);

        for (Car car : DaoFactory.getCarsDao().all()) {
            request.getSession().setAttribute("carId", car.getId());
            request.getSession().setAttribute("carMake", car.getMake());
            request.getSession().setAttribute("carModel", car.getModel());
            System.out.println("car for each loop " + car.getId());
        }

    }
}
