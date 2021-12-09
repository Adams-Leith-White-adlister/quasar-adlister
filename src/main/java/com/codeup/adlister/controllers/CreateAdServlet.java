package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Car car = new Car(
             // for now we'll hardcode the user id
                Long.parseLong(request.getParameter("user_id")),
                Integer.parseInt(request.getParameter("year")) ,
            request.getParameter("make"),
            request.getParameter("model"),
            Double.parseDouble(request.getParameter("price")),
            request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(car);
        response.sendRedirect("/ads");
    }
}
