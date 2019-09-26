package com.me.jvm.out.memory;

import java.nio.ByteBuffer;

public class NioAllocateOutMemory {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024 * 1024);
		buffer.clear();
	}

}
