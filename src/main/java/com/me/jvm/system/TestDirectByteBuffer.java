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
	 * -XX:+DisableExplicitGC 在代码中调用system.gc 不会触发garbage collection。 但在必要的时候，JVM自己决定Garbage collection。
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
