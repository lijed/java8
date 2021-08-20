/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/17
 **/
public class ThreadLocalDateFormatter {

    private static final ThreadLocal<SimpleDateFormat> threadLocalDateFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static Date formatDate(String strDate) throws ParseException {
        return threadLocalDateFormatter.get().parse(strDate);
    }
}
