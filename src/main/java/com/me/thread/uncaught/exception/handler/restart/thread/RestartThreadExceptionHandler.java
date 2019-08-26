package com.me.thread.uncaught.exception.handler.restart.thread;

import java.lang.Thread.UncaughtExceptionHandler;

public class RestartThreadExceptionHandler implements UncaughtExceptionHandler {

	public void uncaughtException(Thread t, Throwable e) {
	      System.out.printf("Thread: %s\n", t.getId());
	      System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
	      System.out.printf("Stack Trace: \n");
	      e.printStackTrace(System.out);
	      System.out.printf("Thread status: %s\n", t.getState());
	      new Thread(new WithUncaughtExceptionHandlerTask()).start();
	}

}
