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

@WebServlet(name = "EditCarServlet", urlPatterns = "/edit-car/*")
public class EditCarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if (req.getSession().getAttribute("user") == null) {
//			resp.sendRedirect("/login");
//		}

		int carId = Integer.parseInt(request.getParameter("carId"));

		try {
			request.setAttribute("car", DaoFactory.getCarsDao().getCarById(carId));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/cars/edit-car.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		int carId = Integer.parseInt(request.getParameter("carId"));

		try {
			Car car = (Car) DaoFactory.getCarsDao().getCarById(carId);
			DaoFactory.getCarsDao().updateCar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
