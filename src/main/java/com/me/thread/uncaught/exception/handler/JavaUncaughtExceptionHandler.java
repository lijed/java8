package com.me.thread.uncaught.exception.handler;

public class JavaUncaughtExceptionHandler {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				throw new RuntimeException();
			}
		});
		
		myThread.setUncaughtExceptionHandler(new MeUncaughtExceptionHandler());

		myThread.start();
	}

}
