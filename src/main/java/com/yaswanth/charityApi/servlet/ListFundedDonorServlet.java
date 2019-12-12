package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yaswanth.charityApi.controller.DonorlistController;
import com.yaswanth.charityApi.controller.ListFundRequestController;
import com.yaswanth.charityApi.controller.ListFundedDonorController;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Request;

/**
 * Servlet implementation class ListFundedDonorServlet
 */
public class ListFundedDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ListFundedDonorController controller = new ListFundedDonorController();
		Request requestobj = new Request();
		String json = null;
		try {
			String fundType = request.getParameter("fundType");
			if (fundType != null && !"".equals(fundType)) {
				requestobj.setFundType(fundType);
				json = controller.fundlist(fundType);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}
}