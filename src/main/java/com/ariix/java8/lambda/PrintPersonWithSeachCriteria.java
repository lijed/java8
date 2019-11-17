package com.ariix.java8.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrintPersonWithSeachCriteria {

	public static void main(String[] args) {
		// Method 1
		Person.printPersons(getPerson(),
				new CheckPersonEligibleForSelectiveService());

		// Method2
		Person.printPersons(getPerson(), new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return p.gender == Person.Sex.MALE && p.getAge() >= 18
						&& p.getAge() <= 25;
			}
		});
	}

	public static List<Person> getPerson() {
		List<Person> roster = new ArrayList<Person>();
		Person jam = new Person("Jam", LocalDate.of(2000, 12, 1),
				Person.Sex.MALE, "test.li@ariix.com");
		roster.add(jam);
		Person peter = new Person("peter", LocalDate.of(1990, 12, 1),
				Person.Sex.MALE, "test.li@ariix.com");
		roster.add(peter);
		Person lily = new Person("lily", LocalDate.of(2005, 12, 1),
				Person.Sex.FEMALE, "test.li@ariix.com");
		roster.add(lily);
		Person david = new Person("david", LocalDate.of(1990, 12, 1),
				Person.Sex.MALE, "test.li@ariix.com");
		roster.add(david);
		Person jerry = new Person("jerry", LocalDate.of(2000, 12, 1),
				Person.Sex.MALE, "test.li@ariix.com");
		roster.add(jerry);
		return roster;

	}

}
