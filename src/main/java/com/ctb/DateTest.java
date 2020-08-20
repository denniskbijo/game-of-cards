package com.ctb;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		double amount = 100.45;
		String format = String.format("%.2f", amount);
		Double form = Double.parseDouble(format);
		// System.out.println(format);
		String dateString = "01/04/202017:30";
		FastDateFormat tripFormat = FastDateFormat.getInstance("dd/MM/yyyyHH:mm", TimeZone.getTimeZone("GMT+08:00"));
		Date date = tripFormat.parse(dateString);
		System.out.println(date);
	}

}
