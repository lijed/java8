package com.ariix.java8.lambda.state.change;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public interface StateChangeListener {
	public void onStateChange(State oldState, State newState);

	public static void log() {}
	
	public static void log1() {}

	public default void doSomething() {}

	public default void doSomething1() {}
	
	default public void printUtf8Info(State state, OutputStream outputSteam) {
		try {
			outputSteam.write(state.getName().getBytes(Charset.forName("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
