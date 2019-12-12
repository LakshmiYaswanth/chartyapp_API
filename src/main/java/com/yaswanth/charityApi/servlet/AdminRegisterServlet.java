package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.AdminRegisterController;
import com.yaswanth.myfundingapp.model.Admin;



/**
 * Servlet implementation class AdminRegisterServlet
 */
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminRegisterController registerController = new AdminRegisterController();
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		String password =request.getParameter("password");
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		String json = registerController.adminRegister(admin);
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}