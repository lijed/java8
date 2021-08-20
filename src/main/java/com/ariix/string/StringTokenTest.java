/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.string;

import java.io.File;
import java.util.StringTokenizer;

/**
 * @author Administrator
 * @date 2020/12/7 22:18
 * Project Name: java8
 */
public class StringTokenTest {
    public static void main(String[] args) {
        StringTokenizer var2 = new StringTokenizer("a;b;c", File.pathSeparator);
        int var3 = var2.countTokens();
        while (var2.hasMoreTokens()) {
            System.out.println(var2.nextElement());
        }
    }
}
