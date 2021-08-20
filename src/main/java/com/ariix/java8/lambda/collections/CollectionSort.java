package com.ariix.java8.lambda.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionSort {
	public static void main(String[] args) {
		
//		listSort();
		
		List<Developer> devs = getDevelopers();
		System.out.println("Print before sort");
		printDevsInfo(devs);
		
		//lambda
		devs.sort((Developer d1, Developer d2)-> d1.getAge() - d2.getAge());
		System.out.println("Print after sort");
		printDevsInfo(devs);
		
		//Lambda valid, parameter type is optional
		devs.sort((d1, d2)-> d1.getSalary().compareTo(d2.getSalary()));
		System.out.println("Print after sort");
		printDevsInfo(devs);
	}

	public static void printDevsInfo(List<Developer> listDevs) {
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
	}

	public static void listSort() {
		List<Developer> devs = getDevelopers();
		devs.sort(new Comparator<Developer>() {
			@Override
			public int compare(Developer d1, Developer d2) {
				return d1.getAge() - d2.getAge();
			}
		});
		
		devs.sort(new Comparator<Developer>() {
			@Override
			public int compare(Developer d1, Developer d2) {
				return d1.getSalary().compareTo(d2.getSalary());
			}
		});
		
		devs.sort(new Comparator<Developer>() {
			@Override
			public int compare(Developer d1, Developer d2) {
				return d1.getName().compareTo(d2.getName());
			}
		});
	}
	
	
	public static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		
		return result;

	}
}
