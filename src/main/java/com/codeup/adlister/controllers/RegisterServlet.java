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

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String preHashedPassword = request.getParameter("password");
            String password = BCrypt.hashpw(preHashedPassword, BCrypt.gensalt());

            if (request.getSession().getAttribute("user") != null) {
                response.sendRedirect("/profile");
            }

            if(username == null || email == null || password == null){
                response.sendRedirect("/register");
                return;
            }
            if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                response.sendRedirect("/register");
                return;
            }

            DaoFactory.getUsersDao().insert(new User(username, email, password));

            response.sendRedirect("/login");
        }
}
