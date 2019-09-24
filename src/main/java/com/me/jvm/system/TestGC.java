package com.me.jvm.system;


public class TestGC {

	/**
	 * 	0. -verbosegc
	 *  1. Use G1 GC JVM parameters: -XX:+PrintGCDetails -XX:+UseG1GC
	 *  3. -XX:+ExplicitGCInvokesConcurrent  使用并发的内存回收
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TestGC();
		System.gc();
		System.runFinalization();
	}

}

//[GC (System.gc())  3870K->712K(247296K), 0.0010510 secs]
//[Full GC (System.gc())  712K->545K(247296K), 0.0054970 secs]
