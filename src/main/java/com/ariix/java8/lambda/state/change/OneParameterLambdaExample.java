package com.ariix.java8.lambda.state.change;

import java.util.Calendar;

public class OneParameterLambdaExample {
	public static interface NoParameterInterface {
		void print(String p1, String p2);
	}

	public static void main(String[] args) {
		NoParameterInterface printer = (p1, p2) -> {
			System.out.println("content " + p1 + ", " + p2
					+ Calendar.getInstance().getTime().toString());
		};
		printer.print("tell", "story");
		
		printer = (param1, param2) -> {
			System.out.println("content " + param1
					+ Calendar.getInstance().getTime().toString());
		};
		printer.print("test", "story");
		
	}

}
