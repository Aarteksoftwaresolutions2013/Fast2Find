package com.ftf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String getYYYYMMDDDate(String date1) {
		if (date1.equals("Select Date")) {
			return date1;
		} else {
			SimpleDateFormat userDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat dateFormatNeeded = new SimpleDateFormat(
					"yyyy/MM/dd");
			Date date = null;
			try {
				date = userDateFormat.parse(date1);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String convertedDate = dateFormatNeeded.format(date);
			return convertedDate;
		}
	}

}
