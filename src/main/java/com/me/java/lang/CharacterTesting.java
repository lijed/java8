package com.me.java.lang;

public class CharacterTesting {
	public static void main(String[] args) {
//		char input = '-';
//		if (Character.isLetter(input)) {
//			System.out.println(" is letter");
//		} else {
//			System.out.println(" is not letter");
//		}
//		
//		if (Character.isAlphabetic(input)) {
//			System.out.println(" is letter");
//		} else {
//			System.out.println(" is not letter");
//		}
		
		String inputs = "aAAaa -aa";
		char[] chaArr= inputs.toCharArray();
		boolean isValid = true;
		for (char i : chaArr) {
			if (Character.isLetter(i)==false  && Character.isSpaceChar(i)==false) {
				
				System.out.println("Invalid input");
				
			}
		}
		if (isValid) {
			System.out.println("valid input");
		}
		
	
	}
}
