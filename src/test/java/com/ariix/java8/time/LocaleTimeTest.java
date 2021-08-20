/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/17
 **/
public class LocaleTimeTest {

    @Test
    public void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        int hour = localTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println("hour = " + hour);
    }
}
