package com.me.thread.uncaught.exception.handler;

import java.lang.Thread.UncaughtExceptionHandler;

public class MeUncaughtExceptionHandler implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
		System.err.println("Thread name: " + t.getName() + " throws exception"  + e.getClass());
		System.out.println("Thread state: " + t.getState().name());
		e.printStackTrace(System.err);
	}

}
