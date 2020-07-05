package com.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
        System.out.println("Enter month (mm): ");
        String month = in.next();
        System.out.println("Enter day (dd): ");
        String day = in.next();
        System.out.println("Enter year (yyyy): ");
        String year = in.next();
        
        System.out.println(getDay(day, month, year));

        Date date = getDate(day, month, year);
        System.out.println(date);
    }
	
	private static String getDay(String day, String month, String year) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
	    return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
	}

    private static Date getDate(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
        return calendar.getTime();
    }

}
