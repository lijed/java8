/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * 测试时间校正器
 *
 * TemporalAdjuster
 * TemporalAdjusters
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class TestTemporalAdjuster {



    @Test
    public void testTimeAdjuster() {
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.dayOfWeekInMonth(5, DayOfWeek.FRIDAY));
        System.out.println(localDateTime);
    }

    @Test
    public void testTestNextMonday() {
        LocalDateTime localDateTime = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println(localDateTime);
    }

    @Test
    public void testCustomTemporal() {
        LocalDateTime localDateTime = LocalDateTime.now().with((t) -> {
           LocalDateTime localDateTime1 = (LocalDateTime) t;
            final DayOfWeek dayOfWeek = localDateTime1.getDayOfWeek();
            if (DayOfWeek.FRIDAY == dayOfWeek) {
                return localDateTime1.plusDays(3);
            } else  if (DayOfWeek.SATURDAY == dayOfWeek) {
                return localDateTime1.plusDays(2);
            } else {
                return  localDateTime1.plusDays(1);
            }
        });

        System.out.println("系统当前日期：" + LocalDateTime.now());
        System.out.println("下一个工作日："  + localDateTime);
    }
}
