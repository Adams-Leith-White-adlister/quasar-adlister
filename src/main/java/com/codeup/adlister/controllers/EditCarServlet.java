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
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "EditCarServlet", urlPatterns = "/edit-car/*")
public class EditCarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/error");
		} else  {
			int carId = Integer.parseInt(request.getParameter("carId"));

			try {
				request.setAttribute("car", DaoFactory.getCarsDao().getCarById(carId));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/cars/edit-car.jsp").forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int carId = Integer.parseInt(request.getParameter("editId"));
		User user = DaoFactory.getUsersDao().findByUsername((String) request.getSession().getAttribute("user"));

		String price = request.getParameter("price");
		double doublePrice = Double.parseDouble(price.replaceAll(",", ""));

		Car car = new Car(
				carId,
				user.getId(),
				Integer.parseInt(request.getParameter("year")) ,
				request.getParameter("make"),
				request.getParameter("model"),
				doublePrice,
				request.getParameter("description"),
				new Date()
		);

		try {
			DaoFactory.getCarsDao().updateCar(car); // Updates car in DB
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/profile");
	}
}
