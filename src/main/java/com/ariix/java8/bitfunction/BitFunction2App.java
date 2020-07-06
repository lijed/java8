package com.ariix.java8.bitfunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BitFunction2App {

	public static void main(String[] args) {
		// Math.pow(a1, a2) returns Double
		BiFunction<Integer, Integer, Double> func1 = (a1, a2) -> Math.pow(a1, a2);

		// takes Double, returns String
		Function<Double, String> func2 = (input) -> "Result : " + String.valueOf(input);

		String result = func1.andThen(func2).apply(2, 4);

		System.out.println(result);

		String finalResult = powToString(2, 4, func1, func2);

		System.out.println("最后结果：" + finalResult);
		
		Object convertResult = convert(100, 200, (a, b)-> a+b, (r) -> r);
		System.out.println("convertResult: " + convertResult);

	}

	public static <R> R powToString(Integer a1, Integer a2, BiFunction<Integer, Integer, Double> func,
			Function<Double, R> func2) {

		return func.andThen(func2).apply(a1, a2);

	}

	public static <A1, A2, R1, R2> R2 convert(A1 a1, A2 a2, BiFunction<A1, A2, R1> func, Function<R1, R2> func2) {

		return func.andThen(func2).apply(a1, a2);

	}

}
