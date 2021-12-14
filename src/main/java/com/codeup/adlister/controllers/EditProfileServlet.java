package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/edit-profile")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/error");
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/users/edit-profile.jsp").forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

        String preHashedPassword = request.getParameter("password");
        String password = BCrypt.hashpw(preHashedPassword, BCrypt.gensalt());

        User updateUser = new User(
                user.getId(),
                request.getParameter("username"),
                request.getParameter("email"),
                user.setPassword(password)
        );

        try {
            DaoFactory.getUsersDao().updateUser(updateUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //log out user and redirect to login page after they edit their profile
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        response.sendRedirect("/login");

    }

    }
