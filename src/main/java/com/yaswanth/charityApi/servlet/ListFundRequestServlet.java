package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yaswanth.charityApi.controller.ListFundRequestController;
/**
 * Servlet implementation class ListFundRequestServlet
 */
public class ListFundRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

ListFundRequestController donorController = new ListFundRequestController();
		String json = null;
		json = donorController.list();
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}

