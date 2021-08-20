/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import org.junit.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/17
 **/
public class DurationTest {


    @Test
    public void test() throws InterruptedException {
        LocalTime start = LocalTime.now();

        TimeUnit.SECONDS.sleep(2);


        LocalTime end = LocalTime.now();

        Duration duration = Duration.between(start, end);
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());

    }


    /**
     * Duration is only LacalTime，用LocalDate来算duration是不支持的
     */
    @Test
    public void testDurationBetweenLocalDate() {
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(0);
        Duration duration = Duration.between(start, end);
        System.out.println("seconds: " + duration.getSeconds());
    }
    @Test
    public void testPeriodBetweenLocalDate() {
        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(1);
        Period period = Period.between(start, end);
        System.out.println(period);
        System.out.println("days: " + period.getDays());
        System.out.println("months: " + period.getMonths());
        System.out.println("years: " + period.getYears());
    }
}
