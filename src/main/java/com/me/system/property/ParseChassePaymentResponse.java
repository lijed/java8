package com.me.system.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.function.Consumer;

public class ParseChassePaymentResponse {

	public static void main(String[] args) throws IOException {
		
		InputStream it = ParseChassePaymentResponse.class.getResourceAsStream("chase.response.properties");
		Properties p = new Properties();
		p.load(it);
		p.keySet().stream().sorted().forEach(new Consumer<Object>() {
			@Override
			public void accept(Object key) {
				System.out.println(key.toString() + "=" + p.getProperty(key.toString()));
			}
		});
	}

}
