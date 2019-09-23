package com.me.jdk.string;

/**
 * JDk1.5
 *
 */
public class StringIntern {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = new String("1");
		s1.intern();
		String s2 = "1";
		System.out.println(s1 == s2); // JDK 1.6, it returns false; from JDK 1.7, it return false
		System.out.println(s1.intern() == s2);
		
		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);  // JDK 1.6, it returns false; from JDK 1.7 and onwards,  it return true, because from JDK 1.7, String pool and String object all are placed in
		 //Head area
		
		System.out.println(s3.intern() == s4);
	}

}
