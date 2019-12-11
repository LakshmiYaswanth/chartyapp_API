package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yaswanth.charityApi.controller.DonorRegisterController;
import com.yaswanth.myfundingapp.model.Donor;

/**
 * Servlet implementation class DonorRegisterServlet
 */
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DonorRegisterController registerController = new DonorRegisterController();
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		String age = request.getParameter("Age");
	    Integer Age = Integer.parseInt(age);
		Donor donor = new Donor();
		donor.setName(name);
		donor.setEmail(email);
		donor.setPassword(password);
		donor.setAge(Age);
		String json = registerController.donorRegister(donor);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}