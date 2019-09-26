package com.me.jvm.out.memory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;


/**
 * Referring：http://www.360doc.com/content/19/0925/16/66500165_863157955.shtml
 *
 */
public class AllocateDuiWaiMemory {
	private static final Unsafe unsafe;
	private static long longArrayOffset;

//	注意：Unsafe分配出来的内存是无法进行垃圾回收的。你得把它当成一种正常的资源，自己去进行管理
	
	static {
		
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		longArrayOffset = unsafe.arrayBaseOffset(long[].class);
		System.out.println("longArrayOffset: " + longArrayOffset);

		System.out.println("long array element size: "
				+ unsafe.arrayIndexScale(long[].class));

		System.out.println("-1 to hexidecial: "
				+ Long.toHexString(-1L).toUpperCase());
	}

	public static void main(String[] args) {
		final long[] ar = new long[1000];
		
		int a= ar.length; // 数组的长度类型是整形，占用4个字节
		
		
		final int index = ar.length - 1;
		ar[index] = -1; // FFFF FFFF FFFF FFFF
		System.out.println("Index = " + index);
		System.out.println("Before change = " + Long.toHexString(ar[index]));

		//数据元素是long，每个元素的唯一量为8
		for (long i = 0; i < 8; ++i) {
			unsafe.putByte(ar, longArrayOffset + 8L * index + i, (byte) 0);
			System.out.println("After change: i = " + i + ", val[" + index+ "] = " + Long.toHexString(ar[index]));
		}
		
		allocateMemory();
	}

	/**
	 * 使用Unsafe 申请新的内存
	 */
	public static void allocateMemory() {
		final int size = Integer.MAX_VALUE / 2;
		final long addr = unsafe.allocateMemory(size);
		try {
			System.out.println("Unsafe address = " + addr);
			for (int i = 0; i < size; ++i) {
				unsafe.putByte(addr + i, (byte) 123);
				if (unsafe.getByte(addr + i) != 123)
					System.out.println("Failed at offset = " + i);
			}
			
			for (int i = 0; i < 10; ++i) {
				System.out.println(unsafe.getChar(addr + i));
			}
			
		} finally {
			unsafe.freeMemory(addr);
		}

		
	}

}
