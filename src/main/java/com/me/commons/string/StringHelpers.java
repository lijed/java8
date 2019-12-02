package com.me.commons.string;

import org.apache.commons.lang3.StringUtils;

public class StringHelpers {

    public static final String[] NEED_REPLACED_CHARACTERS = {" ",",", "/", "\\",";","'"};
    public static final String[] NEED_REPLACING_CHARACTERS = {"","","","","",""};
    
	public static void main(String[] args) {
//		replaceListString();
		String validName = "李宝强";
		boolean isEachCharacterExisted = false;
		String realName = "宝强李";
		for (int i = 0; i < realName.length(); i++) {
			if (StringUtils.contains(validName, realName.substring(i, i+1))) {
				isEachCharacterExisted = true;
			} else {
				isEachCharacterExisted = false;
				break;
			}
		}
		System.err.println(isEachCharacterExisted);
	}

	private static void replaceListString() {
		String finalResult = StringUtils.replaceEach("李, \\ 宝;强/'", NEED_REPLACED_CHARACTERS,
				NEED_REPLACING_CHARACTERS);
		System.out.println(finalResult);
	}

}
