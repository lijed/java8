package com.me.thread.uncaught.exception.handler.restart.thread.dataprocess;

import java.util.List;

public class DataProcessTask implements Runnable {
	
	private List<DataRecord> data;

	public DataProcessTask(List<DataRecord> data) {
		super();
		this.data = data;
	}


	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(new RestartThreadExceptionHandler(data));
		for (DataRecord dRecord : data) {
			if (dRecord.isProcessed() == false) {
				try {
					dRecord.setResult(Integer.parseInt(dRecord.getData()));
					System.out.println(dRecord.getIndex() + " org data: " + dRecord.getData() + " parsed result: "  + dRecord.getResult());
				} catch (Exception e) {
					dRecord.setProcessed(true);
					throw new RuntimeException(e);
				}
			}
		}
	}

}
