package com.me.jdk.string;

import java.nio.charset.Charset;

public class StrUtils {

	public static void main(String[] args) {
		String str = "广州市荔湾区东风西路广雅前街23号907房";
		byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
		byte[] newBytes = new byte[2];
		System.arraycopy(bytes, 0, newBytes, 0, 2);
		String newStr = new String(newBytes);
		System.out.println("new str: "+ newStr);
		
		
	}

}
