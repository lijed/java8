package com.me.java.util.concurrent;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TimeUnitTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -10);
		Long startTimeInMinutes =TimeUnit.MILLISECONDS.toMinutes(calendar.getTimeInMillis());
		Long endTimeInMinutes = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());// TODO Auto-generated method stub
		System.out.println(endTimeInMinutes - startTimeInMinutes);
	}

}
