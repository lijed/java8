/*
 * Copyright 2020 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.formatter;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Formatter;

/**
 * @author Administrator
 * @date 2020/12/7 16:46
 * Project Name: java8
 */
public class FormatterUtils {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format("%09d", 5);
        String formattedResult = formatter.out().toString();
        System.out.println("formatResult = " + formattedResult);
    }
}
