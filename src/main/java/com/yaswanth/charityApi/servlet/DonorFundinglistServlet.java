package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.DonorFundinglistController;


/**
 * Servlet implementation class DonorFundinglistServlet
 */
public class DonorFundinglistServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DonorFundinglistController controller = new DonorFundinglistController();
			String req = null;
			String name = request.getParameter("name");
			req =controller.fundlist(name);
		    PrintWriter out = response.getWriter();
			out.write(req);
		}
		}
