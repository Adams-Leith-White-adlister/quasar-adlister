package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Car;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/cars/create")
public class CreateCarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("user") == null){
            response.sendRedirect("/error");
        } else {
            request.getRequestDispatcher("/WEB-INF/cars/create-car.jsp")
                    .forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

        String price = request.getParameter("price");
        double doublePrice = Double.parseDouble(price.replaceAll(",", ""));
        String capMake = request.getParameter("make").substring(0, 1).toUpperCase() + request.getParameter("make").substring(1);
        String capModel = request.getParameter("model").substring(0, 1).toUpperCase() + request.getParameter("model").substring(1);

        Car car = new Car(
                user.getId(),
                Integer.parseInt(request.getParameter("year")) ,
                capMake,
                capModel,
                doublePrice,
                request.getParameter("description")
        );
        DaoFactory.getCarsDao().insert(car);
        response.sendRedirect("/profile");
    }
}
