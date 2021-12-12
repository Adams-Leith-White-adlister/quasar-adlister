package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");



        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        User userVar = DaoFactory.getUsersDao().findByUsername(username);

        if(userVar == null) {
            //response.sendRedirect("/loginError");
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "ERROR! incorrect username or password");
            response.sendRedirect("/login");
            return;
        }

        String userPassword = userVar.getPassword();
        boolean passwordMatch = BCrypt.checkpw(password, userPassword);
        boolean validAttempt = username.equals(userVar.getUsername()) && passwordMatch;

        if (validAttempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            JFrame frame = new JFrame();
            //response.sendRedirect("/loginError");
            JOptionPane.showMessageDialog(frame, "ERROR! incorrect username or password");
            response.sendRedirect("/login");
        }
    }
}
