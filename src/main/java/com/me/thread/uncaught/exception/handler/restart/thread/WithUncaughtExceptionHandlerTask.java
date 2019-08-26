package com.me.thread.uncaught.exception.handler.restart.thread;

public class WithUncaughtExceptionHandlerTask extends Task {

	@Override
	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(new RestartThreadExceptionHandler());
		super.run();
	}

}
