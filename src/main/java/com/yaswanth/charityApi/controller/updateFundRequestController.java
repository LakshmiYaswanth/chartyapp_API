package com.yaswanth.charityApi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Request;
import com.yaswanth.myfundingapp.service.RequestService;

/**
 * @author yaswanth
 * This class consists of fund request operation
 */
public class updateFundRequestController {
	 /**
     * This  method will be shown in test case to updating the Fund request in the application
     * @param fundtype
     * @param amount
     * @param expireDate
     * @param adminId
	 * @return json
     */
	public String updateFundRequest(Request request)
	{
		RequestService service = new RequestService();
		String error=null;
		 int rows=0;
		try {
			rows = service.RequestUpdate(request);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		 
		 String json = null;
		 Gson gson = new Gson();
		 if(rows !=0)
		 {
			 json = gson.toJson(rows);
		 } else {
			 JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", error);
			json = jsonObj.toString();
			} 
		return json;
	}
}
