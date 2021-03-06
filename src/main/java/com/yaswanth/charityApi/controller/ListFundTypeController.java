package com.yaswanth.charityApi.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.model.RequestType;
import com.yaswanth.myfundingapp.service.RequestService;

public class ListFundTypeController {
	/** List fund type where we have to give only valid inputs 
	 * @param
	 * @return json
	 */
	public String fundlist() {
		RequestService service = new RequestService();
		List<RequestType> request1 = null;
		try {
			request1=new ArrayList<RequestType>();
			request1 = service.Fundtypelist();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String json=null;
		Gson gson = new Gson();
		json = gson.toJson(request1);
		return json;
	}
	public static void main(String args[]) {
		ListFundTypeController obj = new ListFundTypeController();
			String json = obj.fundlist();
	        System.out.println(json);
	}
}