package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.AdminLoginController;
import com.yaswanth.myfundingapp.model.Admin;

/**
 * Servlet implementation class AdminloginServlet
 */
public class AdminloginServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				Admin admin = new Admin();
				AdminLoginController loginController = new AdminLoginController();
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				admin.setName(name);
				admin.setPassword(password);
				String json = loginController.adminLogin(name,password);
				PrintWriter out = response.getWriter();
				out.write(json);
				out.flush();
			
		}

	}