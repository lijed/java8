package com.ariix.java8.lambda.state.change;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public interface MyInterface {
	
	public void printIt(String text);
	
	default public void printUtf8Info(String text, OutputStream outputSteam) {
		try {
			outputSteam.write(text.getBytes(Charset.forName("UTF-8")));
			outputSteam.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputSteam != null) {
				try {
					outputSteam.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void printItToSystem (String text) {
		System.out.println(text);
	}
}
