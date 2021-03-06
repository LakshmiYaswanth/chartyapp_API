package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.TransactionController;
import com.yaswanth.myfundingapp.model.Transaction;

/**
 * Servlet implementation class TransactionServlet
 */
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Transaction transactionObj = new Transaction();
		TransactionController controllerObj = new TransactionController();
		String Id = request.getParameter("donorId");
		Integer donorId = Integer.parseInt(Id);

		String fundRequestId = request.getParameter("requestId");
		Integer RequestId = Integer.parseInt(fundRequestId);

		String amount = request.getParameter("amount");
		Integer requestAmount = Integer.parseInt(amount);

		transactionObj.setDonorId(donorId);
		transactionObj.setRequestId(RequestId);
		transactionObj.setAmountfunded(requestAmount);
		
		String json = controllerObj.transaction(transactionObj);
		
		PrintWriter out = response.getWriter();
		out.write(json);
		out.flush();
	}

}
