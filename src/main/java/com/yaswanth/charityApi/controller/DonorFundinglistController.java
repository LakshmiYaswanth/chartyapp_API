package com.yaswanth.charityApi.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.yaswanth.myfundingapp.exceptions.DBExeception;
import com.yaswanth.myfundingapp.model.Donor;
import com.yaswanth.myfundingapp.service.DonorService;

/**
* @author yaswanth
* This class consists of donor operations
*/
public class DonorFundinglistController {
	/**
     * This  method will be shown in test case to Donor List for a given name in the application
     * @param name
	 * @throws DBException
	 * @return json
     */
	DonorService service = new DonorService();
		public String fundlist(String email)  {
			List<Donor> list = new ArrayList<Donor>();
				try {
					list = service.fundingList(email);
				} catch (DBExeception e) {
					e.printStackTrace();
				}
			String json=null;
			Gson gson = new Gson();
			json = gson.toJson(list);
			return json;
		}
		public static void main(String args[]) {
			DonorFundinglistController obj = new DonorFundinglistController();
				String json = obj.fundlist("ram@gmail.com");
		    System.out.println(json);
		}
	}
		
