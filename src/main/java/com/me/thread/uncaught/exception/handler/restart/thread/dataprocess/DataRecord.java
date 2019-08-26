package com.me.thread.uncaught.exception.handler.restart.thread.dataprocess;


public class DataRecord {
	private String data;
	private Integer result;
	private boolean isProcessed;
	private int index;

	public DataRecord(String data, int index) {
		super();
		this.data = data;
		this.index = index;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
		setProcessed(true);
	}

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public static DataRecord Instance(String data, int index) {
		return new DataRecord(data, index);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
