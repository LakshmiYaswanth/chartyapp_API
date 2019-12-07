package com.yaswanth.charityApi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yaswanth.charityApi.controller.updateFundRequestController;
import com.yaswanth.myfundingapp.model.Request;

/**
 * Servlet implementation class updateFundRequestServlet
 */
public class updateFundRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			updateFundRequestController updateFundControl = new updateFundRequestController();
			Request req = new Request();
			String fundType = request.getParameter("fundType");
			String targetAmount = request.getParameter("amount");
			Integer amount = Integer.parseInt(targetAmount);
			String expireDate = request.getParameter("date");
			LocalDate date = LocalDate.parse(expireDate);
			String RequestId = request.getParameter("requestId");
			Integer id=Integer.parseInt(RequestId);
			req.setFundType(fundType);
			req.setAmount(amount);
			req.setExpireDate(date);
			req.setRequestId(id);
			String json = updateFundControl.updateFundRequest(req);
			PrintWriter out = response.getWriter();
			out.write(json);
		}

		

	}
