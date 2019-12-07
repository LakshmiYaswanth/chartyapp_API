package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.DonorLoginController;
import com.yaswanth.myfundingapp.model.Donor;

/**
 * Servlet implementation class DonorLoginServlet
 */

public class DonorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Donor donor = new Donor();
		DonorLoginController loginController = new DonorLoginController();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		donor.setName(name);
		donor.setPassword(password);
		String req = loginController.donorLogin(name,password);
		PrintWriter out = response.getWriter();
		out.write(req);
		out.flush();
		
	}

}
