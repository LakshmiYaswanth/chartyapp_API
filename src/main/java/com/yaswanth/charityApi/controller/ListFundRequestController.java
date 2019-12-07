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
public class ListFundRequestController {
	/** List fund type where we have to give only valid inputs 
	 * @param fundType
	 * @return json
	 */
	public String list() {
		RequestService service = new RequestService();
		List<Request> request1 = null;
		try {
			request1=new ArrayList<Request>();
			request1 = service.list();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(request1);
		return json;
	}
	public static void main(String args[]) {
		ListFundRequestController obj = new ListFundRequestController();
			String json = obj.list();
	        System.out.println(json);
	}
}
	
	