package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.RequestStatusController;

/**
 * Servlet implementation class RequestStatusServlet
 */
public class RequestStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestStatusController controller=new RequestStatusController();
		String request_Id = request.getParameter("requestId");
	    Integer requestId = Integer.parseInt(request_Id);
	    String json =controller.requestStatus(requestId);
		PrintWriter out = response.getWriter();
		out.write(json);	
	}

}
