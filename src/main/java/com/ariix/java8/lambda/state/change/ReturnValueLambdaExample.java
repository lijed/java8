package com.ariix.java8.lambda.state.change;

import java.util.Calendar;

public class ReturnValueLambdaExample {
	private static final String test = "test";
	public static interface ReturnInterface {
		String print(String p1);
	}

	public static void main(String[] args) {
		ReturnInterface printer = (p1) -> {
			System.out.println(test + p1   +  "at"
					+ Calendar.getInstance().getTime().toString());
			return "yes";
		};
		printer.print("tell");
		
		String preApp = "the whole content";
		printer = (param1) -> {
			System.out.println(preApp + param1
					+ Calendar.getInstance().getTime().toString());
			String a = "yes";
			return param1 + a;
		};
		printer.print("test");
		
	}

}
