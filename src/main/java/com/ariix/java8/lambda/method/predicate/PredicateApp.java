package com.ariix.java8.lambda.method.predicate;

import java.util.function.Predicate;

public class PredicateApp {

	public static void main(String[] args) {
		Predicate<Integer> isAdult = (age) -> {
			if (age.intValue() >= 18) {
				return true;
			} else {
				return false;
			}
		};
		
		Predicate<Integer> isExpert = (workYears) -> {
			if (workYears.intValue() >= 10) {
				return true;
			} else {
				return false;
			}
		};
		
		System.out.println(isAdult.test(20));
		
		System.out.println(isAdult.and(isExpert).test(85));
	}

}
