package com.ariix.java8.lambda.bitfunction;

import java.util.function.BiFunction;

public class App {

	public static void main(String[] args) {
		Printer p = new Printer();
		execute("test", "a", p::print);
	}
	


	public static void execute(String b, String a, BiFunction<String, String, String> function) {
		String result = function.apply(a, b);
		System.out.println(result);
	}

}
