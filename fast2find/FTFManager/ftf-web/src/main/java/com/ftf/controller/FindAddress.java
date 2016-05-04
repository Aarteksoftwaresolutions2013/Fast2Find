package com.ftf.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindAddress {
	
	public static void main(String[] args) {
		 String date1="12/26/2014";
		SimpleDateFormat userDateFormat = new SimpleDateFormat("MM/dd/yyyy");  
	        SimpleDateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd");  
	        Date date = null;
	        String convertedDate=null;
	        try {
				   date = userDateFormat.parse(date1);
			   	 convertedDate = dateFormatNeeded.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	       
	        System.out.println(convertedDate);
	}
}