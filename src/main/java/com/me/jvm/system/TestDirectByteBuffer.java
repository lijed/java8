package com.me.jvm.system;

import java.nio.ByteBuffer;

public class TestDirectByteBuffer {

	/**
	 * JVM Parameters: -verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40m
	 * 
	 * Sets the maximum total size (in bytes) of the New I/O (the java.nio package) direct-buffer allocations. 
	 * Append the letter k or K to indicate kilobytes, m or M to indicate megabytes, g or G to indicate gigabytes. By default, the size is set to 0, meaning that the JVM chooses the size for NIO direct-buffer allocations automatically.
	 *	The following examples illustrate how to set the NIO size to 1024 KB in different units:
	 * -XX:MaxDirectMemorySize=1m
	 * -XX:MaxDirectMemorySize=1024k
	 * -XX:MaxDirectMemorySize=1048576
	 * 
	 * 
	 * -XX:+DisableExplicitGC 这个参数作用是禁止代码中显示调用GC。代码如何显示调用GC呢，通过System.gc()函数调用。如果加上了这个JVM启动参数，那么代码中调用System.gc()没有任何效果，相当于是没有这行代码一样。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			ByteBuffer buffer = ByteBuffer.allocateDirect(10 * 1024 * 1024);
			System.gc();
		}
	}

}
