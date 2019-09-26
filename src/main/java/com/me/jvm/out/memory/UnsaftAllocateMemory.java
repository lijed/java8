package com.me.jvm.out.memory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

import com.me.jvm.system.SystemInfo;

public class UnsaftAllocateMemory {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		SystemInfo.displayJvmMemoryInfo();
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);
		unsafe.allocateMemory(Integer.MAX_VALUE); // byte
		SystemInfo.displayJvmMemoryInfo();
	}
}
