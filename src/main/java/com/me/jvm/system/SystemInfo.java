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

	public static void displayJvmMemoryInfo() {
		Runtime runTime = Runtime.getRuntime();
		System.out.println("max momory (M): " + (runTime.maxMemory()/ 1024 / 1024));
		System.out.println("total memory(M):" + (runTime.totalMemory()/ 1024 / 1024));
		System.out.println("free memory(M):" + (runTime.freeMemory()/ 1024 / 1024));

		// max momory: 954728448 -Xmx
		// total memory:253231104
		// free memory:250588664

	}
}
