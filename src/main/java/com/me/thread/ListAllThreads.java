package com.me.thread;

import java.util.Arrays;
import java.util.Set;

public class ListAllThreads {

	public static void main(String[] args) {
		
		System.out.println("current thread name - " + Thread.currentThread().getName());
		
//		 for (Thread t : Thread.getAllStackTraces().keySet()) {
//		     System.out.println(t.getName());
//		 }
		
		listAllThreadFromThreadGroup();
	}
	
	public static Thread getThreadByName(String threadName) {
	    Thread __tmp = null;

	    //run time的某一时间点的快照
	    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	    Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);

	    for (int i = 0; i < threadArray.length; i++) {
	        if (threadArray[i].getName().equals(threadName))
	            __tmp =  threadArray[i];
	    }

	    return __tmp;
	}
	
	public static void listAllThreadFromThreadGroup() {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		
		int activeThreadCount = threadGroup.activeCount();
		System.out.println("Active ThreadCount: " + activeThreadCount);
		
		Thread[] allThreads = new Thread[10];
		int count = threadGroup.enumerate(allThreads);
		System.out.println("Count: " + count);
		for (int i = 0; i < count; i++) {
			System.out.println(allThreads[i].getName());
		}
	}

}
