package com.yaswanth.charityApi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Admin;
import com.yaswanth.myfundingapp.service.AdminService;

public class AdminRegisterController {
	/**
     * This  method will be shown in test case to Registeration in the application
     * @param strUserName
     * @param strPasword
     * @param StrEmail
     * @parm strAge
	 * @throws DBException 
	 * @return jsondata
     */
	public String adminRegister(Admin admin) {
	
		AdminService service = new AdminService();
		int rows=0;
		String json = null;
		try {
			rows = service.adminInsert(admin);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		if (rows != 0) {
			json = gson.toJson(rows);
		} else {
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("errorMessage", rows);
			json = jsonObj.toString();
		}
		return json;
	}
	
}
