package com.me.jdk.reflect;

public class ReflectUtils {

	public static void main(String[] args) {
		String name = ReflectUtils.class.getName();
		System.out.println(name);
		System.out.println( ReflectUtils.class.getSimpleName());
	
	}

}
