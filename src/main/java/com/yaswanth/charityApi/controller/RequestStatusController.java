package com.yaswanth.charityApi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.service.RequestService;

public class RequestStatusController {
	public String requestStatus(int requestId) {
		String errorMsg = null;
		RequestService service = new RequestService();
		int row= 0;
		try {
			row = service.status(requestId);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();
		if (row != 0) {
			json = gson.toJson(row);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		System.out.println(json);
		return json;
	}
	public static void main(String args[]) {
		RequestStatusController obj = new RequestStatusController();
			String json = obj.requestStatus(2);
	    System.out.println(json);
	}
}



