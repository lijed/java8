package com.me.jvm.remembered.set.vm;

import java.util.ArrayList;
import java.util.List;

public class VmRemremberedSetVMParameters {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			numbers.add(i);
		}
		System.out.println("success");
	}

}
