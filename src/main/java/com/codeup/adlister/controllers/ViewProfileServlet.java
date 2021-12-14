package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/error");
        } else {
            try {
                request.setAttribute("cars", DaoFactory.getCarsDao().allByUserId(user.getId()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println();
            request.getRequestDispatcher("/WEB-INF/users/profile.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int carId = Integer.parseInt(request.getParameter("carId"));

        try {
            DaoFactory.getCarsDao().deleteCarById(carId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/profile");

    }

}
