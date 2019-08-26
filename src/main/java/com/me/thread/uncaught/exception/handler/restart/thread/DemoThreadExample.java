package com.me.thread.uncaught.exception.handler.restart.thread;

public class DemoThreadExample {
	public static void main(String[] args) {
		startThreadWithExceptionHandler();
	}

	protected static void startThreadWithoutExceptionHandler() {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
	}
	
	protected static void startThreadWithExceptionHandler() {
		Task task = new WithUncaughtExceptionHandlerTask();
		Thread thread = new Thread(task);
		thread.start();
	}
}
