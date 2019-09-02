package com.me.system.property;

import java.util.Properties;

public class PrintSystemProperties {

	public static void main(String[] args) {
		Properties pros = System.getProperties();
		for (Object key : pros.keySet()) {
			System.out.println(key  +  "--"  + pros.getProperty(key.toString()));
		}
	}

}
