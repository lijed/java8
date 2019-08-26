package com.me.thread.uncaught.exception.handler.restart.thread.dataprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DataProcessFarm {
	
	private static final Random intRandom = new Random(1000);

	public static void main(String[] args) {
		int offset = 0;
		int totalCount = 100;
		List<DataRecord> data = createData(totalCount, offset + 1); //1
		
		offset = offset + totalCount;
		data.add(DataRecord.Instance("aaaa", offset+1)); //101
		offset = offset + 1;
		
		data.addAll(createData(200, offset+1)); //102
		Runnable task = new DataProcessTask(data);
		Thread thread = new Thread(task);
		thread.start();
	}

	private static List<DataRecord> createData(Integer count, int offset) {
		List<DataRecord> dataRecord = new ArrayList<DataRecord>(count);
		for (int i = 0; i < count; i++) {
			dataRecord.add(DataRecord.Instance(String.valueOf(intRandom.nextInt()), offset++));
		}
		return dataRecord;
	}

}
