package com.me.java.util.concurrent;

import java.util.Calendar;

public class CalendarUtils {
	public static void main(String[] args) {
		String firstDigityear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)).substring(2,4);
		System.out.println(firstDigityear);
	}
}
