package com.ariix.java8.bitfunction;

import java.util.function.BiFunction;

public class Java8BitFunction3 {
	public static void main(String[] args) {
		GPS obj = factory("40.741895", "-73.989308", GPS::new);
		System.out.println(obj);
	}

	public static <R extends GPS> R factory(String latitude, String longtude,
			BiFunction<String, String, R> bifunction) {
		return bifunction.apply(latitude, longtude);
	}
}
