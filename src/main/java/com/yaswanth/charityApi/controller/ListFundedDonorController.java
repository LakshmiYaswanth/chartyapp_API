package com.yaswanth.charityApi.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.service.RequestService;

/**
 * @author yaswanth
 * This class consists of fund request operation
 */
public class ListFundedDonorController {
	/**
     * This  method will be shown in test case to Request List for a given name in the application
     * @param name
	 * @return json
     */
	public String fundlist(String fundType) throws ServiceException {
		RequestService service = new RequestService();
		 List<Request> request1=new ArrayList<Request>();
		request1 = service.FundType(fundType);
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(request1);
		return json;
	}
	public static void main(String args[]) throws ServiceException {
		ListFundedDonorController obj = new ListFundedDonorController();
		String json = obj.fundlist("food");
	    System.out.println(json);
	}
}
	