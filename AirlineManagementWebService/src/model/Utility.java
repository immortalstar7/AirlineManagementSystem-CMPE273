package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class Utility {
	public java.sql.Date convertStringToDate(String date_to_convert){
		java.sql.Date sqlDate = null;
		try {
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
			format.setTimeZone(TimeZone.getTimeZone("PST"));
			java.util.Date date = format.parse(date_to_convert);
			System.out.println("Date is: "+date);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlDate;
	}
}
