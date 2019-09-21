package com.me.jvm.system;

import java.util.Map;

public class SystemInfo {
	public static void main(String[] args) {
		// displayEnvVariables();

		System.out.println(253231104 / 1024 / 1024);
		displayJvmMemoryInfo();
	}

	protected static void displayEnvVariables() {
		Map<String, String> envs = System.getenv();
		for (String key : envs.keySet()) {
			System.out.println("Key: " + key + " - " + envs.get(key));
		}
	}

	protected static void displayJvmMemoryInfo() {
		Runtime runTime = Runtime.getRuntime();
		System.out.println("max momory: " + runTime.maxMemory());
		System.out.println("total memory:" + runTime.totalMemory());
		System.out.println("free memory:" + runTime.freeMemory());

		// max momory: 954728448 -Xmx
		// total memory:253231104
		// free memory:250588664

	}
}
