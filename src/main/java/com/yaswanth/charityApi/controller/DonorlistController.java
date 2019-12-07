package com.yaswanth.charityApi.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.service.DonorService;

/**
* @author yaswanth
* This class consists of donor operations
*/
public class DonorlistController {
	/**
     * This  method will be shown in test case to Donor List in the application
	 * @return jsondata 
     */
	public String listDonor()
	{
		DonorService service = new DonorService();
		List<Donor> donorList = null;
		String errorMessage = null;
		try {
			donorList=new ArrayList<Donor>();
			donorList = service.list();
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}
		String json = null;
		Gson gson = new Gson();
		if(errorMessage != null)
		{
			json = errorMessage;
		} else {
			json = gson.toJson(donorList);
		}
		return json;
	}
	public static void main(String args[]) {
		DonorlistController obj = new DonorlistController();
			String json = obj.listDonor();
	    System.out.println(json);
	}

}
