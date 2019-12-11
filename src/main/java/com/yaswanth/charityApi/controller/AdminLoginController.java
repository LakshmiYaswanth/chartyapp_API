package com.yaswanth.charityApi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.service.AdminService;

/**
 * @author yaswanth
 * This class consists of admin login 
 *
 */
public class AdminLoginController {
	 /**
     * This  method will be shown in test case to login in the application
     * @param strUserName
     * @param strPasword
	 * @throws Service Exeception
	 * @return json
     */
	public String adminLogin(String name,String password) {
		String errorMsg = null;
		AdminService service = new AdminService();
		Admin adminObj = null;
		try {
			adminObj = service.login(name,password);
		} catch (ServiceException e) {
			errorMsg = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();
		if (adminObj != null) {
			json = gson.toJson(adminObj);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", errorMsg);
			json = jsonObj.toString();
		}
		System.out.println(json);
		return json;
	}
	public static void main(String args[]) {
		AdminLoginController obj = new AdminLoginController();
			String json = obj.adminLogin("ganesh","raj");
	    System.out.println(json);
	}
}

