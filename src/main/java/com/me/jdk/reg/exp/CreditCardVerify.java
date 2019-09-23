package com.me.jdk.reg.exp;

import java.util.regex.Pattern;

public class CreditCardVerify {
	
	public static void main(String[] args) {
		String cardHolderName = "^[A-Za-z ,.'-]{2,26}$";
		Pattern pattern = Pattern.compile(cardHolderName);
		System.out.println(pattern.matcher("AAA aaa").matches());
		System.out.println(pattern.matcher("J. Li aaa").matches());
		System.out.println(pattern.matcher("가가랙랙").matches());
	}
}
