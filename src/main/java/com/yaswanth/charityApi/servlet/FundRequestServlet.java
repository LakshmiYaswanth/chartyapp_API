package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.FundRequestController;
import com.yaswanth.myfundingapp.model.Request;

/**
 * Servlet implementation class FundRequestServlet
 */
public class FundRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		FundRequestController controller = new FundRequestController();
		Request req = new Request();
		String fundType = request.getParameter("fundType");
		String targetAmount = request.getParameter("amount");
		Integer amount = Integer.parseInt(targetAmount);
		String expireDate = request.getParameter("date");
		LocalDate date = LocalDate.parse(expireDate);
		String adminId = request.getParameter("adminId");
		Integer id=Integer.parseInt(adminId);
		req.setFundType(fundType);
		req.setAmount(amount);
		req.setExpireDate(date);
		req.setAdminId(id);
		String isStatus = controller.insert(req);

		String json = "{\"isStatus\"" +":"+"\"" + isStatus + "\"}";
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
