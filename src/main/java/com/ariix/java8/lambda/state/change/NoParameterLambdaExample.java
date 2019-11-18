package com.ariix.java8.lambda.state.change;

import java.util.Calendar;

public class NoParameterLambdaExample {
	public static interface NoParameterInterface {
		void print();
	}

	public static void main(String[] args) {
		NoParameterInterface printer = () -> {
			System.out.println("call me at "
					+ Calendar.getInstance().getTime().toString());
		};
		
		printer.print();

	}

}
