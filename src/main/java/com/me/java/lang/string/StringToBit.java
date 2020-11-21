/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.me.java.lang.string;

/**
 * @author Administrator
 * @date 2020/11/21 22:54
 * Project Name: java8
 */
public class StringToBit {
    public static void main(String[] args) {
        String str = "foobar";
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.println("b = " + b);
        }
    }
}
