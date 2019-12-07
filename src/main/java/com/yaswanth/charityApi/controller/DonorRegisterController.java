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
public class DonorRegisterController {
	/**
     * This  method will be shown in test case to Registeration in the application
     * @param strUserName
     * @param strPasword
     * @param StrEmail
     * @parm strAge
	 * @throws DBException 
	 * @return jsondata
     */
	public String donorRegister(Donor donor) {
	
		DonorService service = new DonorService();
		int rows=0;
		try {
			rows = service.donorInsert(donor);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		String json = null;
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
