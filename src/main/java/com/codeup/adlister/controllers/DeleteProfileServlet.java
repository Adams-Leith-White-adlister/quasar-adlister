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

@WebServlet(name = "DeleteProfileServlet", urlPatterns = "/delete-profile")
public class DeleteProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/login");
		} else {
			request.setAttribute("user", user);
		}

		request.getRequestDispatcher("/WEB-INF/delete-profile.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

		try {
			DaoFactory.getUsersDao().deleteUserById(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/cars");
	}
}
