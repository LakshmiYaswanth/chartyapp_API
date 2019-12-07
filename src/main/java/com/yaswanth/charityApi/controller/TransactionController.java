package com.yaswanth.charityApi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yaswanth.myfundingapp.exceptions.ServiceException;
import com.yaswanth.myfundingapp.model.Transaction;
import com.yaswanth.myfundingapp.service.TransactionService;

/**
 * @author yaswanth
 * This class consists of Transaction operation
 */
public class TransactionController {
	 /**
     * This  method will be shown in test case to inserting the Transaction details in the application
     * @param amountfunded
     * @param donorId
     * @param requestId
	 * @return json
     */
	public String transaction(Transaction transaction)
	{
		TransactionService trans = new TransactionService();
		int rows = 0;
			String error = null;
			try {
				rows = trans.insertservice(transaction);
			} catch (ServiceException e) {
				error = e.getMessage();
			}
			String json = null;
			Gson gson = new Gson();

			if (rows != 0) {
				json = gson.toJson(rows);
			} else {
				JsonObject jsonObj = new JsonObject();
				jsonObj.addProperty("errorMessage", error);
				json = jsonObj.toString();
			}
			return json;
	}
}
