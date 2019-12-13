package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yaswanth.charityApi.controller.ListFundedDonorController;
import com.yaswanth.myfundingapp.exceptions.ServiceException;


/**
 * Servlet implementation class ListFundedDonorServlet
 */
public class ListFundedDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ListFundedDonorController controller = new ListFundedDonorController();
		String json = null;
		try {
			String fundType =request.getParameter("fundType");
			
			if (fundType != null && !"".equals(fundType)) {
				Integer fundtypeId=Integer.parseInt(fundType);
				//requestobj.setFundTypeId(fundType);
				json = controller.fundlist(fundtypeId);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}