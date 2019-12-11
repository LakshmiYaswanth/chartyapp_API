package com.yaswanth.charityApi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.service.DonorService;

/**
* @author yaswanth
* This class consists of donor operations
*/
public class DonorLoginController {
	 /**
     * This  method will be shown in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @param StrEmail
     * @parm strAge 
	 * @return jsondata
     */
	public String donorLogin(String name,String password) {
		DonorService service = new DonorService();
		Donor donorObj = null;
		String errorMsg = null;
		try {
			donorObj = service.login(name,password);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();

		if (donorObj != null) {
			json = gson.toJson(donorObj);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		return json;
	}
	public static void main(String args[]) {
		DonorLoginController obj = new DonorLoginController();
			String json = obj.donorLogin("yas","Yaswh");
	    System.out.println(json);
	}

}
