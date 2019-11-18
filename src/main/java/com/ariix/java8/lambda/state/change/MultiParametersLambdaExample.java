package com.ariix.java8.lambda.state.change;

import java.util.Calendar;

public class MultiParametersLambdaExample {
	public static interface NoParameterInterface {
		void print(String text);
	}

	public static void main(String[] args) {
		NoParameterInterface printer = (param) -> {
			System.out.println("content " + param
					+ Calendar.getInstance().getTime().toString());
		};
		printer.print("tell");
		
		printer = param -> {
			System.out.println("content " + param
					+ Calendar.getInstance().getTime().toString());
		};
		printer.print("test");
		
		printer = (String param) -> {
			System.out.println("content " + param
					+ Calendar.getInstance().getTime().toString());
		};
		
		printer.print(new Object().toString());
	
	}

}
