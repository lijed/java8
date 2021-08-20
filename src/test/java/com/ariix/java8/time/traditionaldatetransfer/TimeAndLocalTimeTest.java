/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time.traditionaldatetransfer;

import org.junit.Test;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class TimeAndLocalTimeTest {


    @Test
    public void testLocalDatToTime() {
        final Time time = Time.valueOf(LocalTime.now());
        System.out.println(time);
    }

    @Test
    public void testDateToLocalTime() {
        final Time time = new Time(System.currentTimeMillis());
        final LocalTime localTime = time.toLocalTime();
        System.out.println(localTime);

        final Instant instant = time.toInstant();
        System.out.println(instant);

    }
}
