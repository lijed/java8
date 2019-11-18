package com.ariix.java8.lambda.state.change;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LambdaExample1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Java  lambda expression can implement interfaces with a single unimplemented method (abstract) method,
		// a single unimplemented method abstract method, but as many default or state methods as you like
		MyInterface myInterface = (String text) -> {
			System.out.println("text: " + text);
		};
		
		myInterface.printIt("test");
		
		myInterface.printUtf8Info("text", new FileOutputStream("tests"));
		
		MyInterface.printItToSystem("Helo World");
	}
}
