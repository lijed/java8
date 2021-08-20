/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/17
 **/
public class LocalDateTimeTest {

    //LocalDate //LocalTime //LocalDateTime


    @Test
    public void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    @Test
    public void testInstantiateWithYearMonth() {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 12, 10, 23, 12);
        System.out.println(localDateTime);
    }

    @Test
    public void testInstantiateWithLocalDateAndTime() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(localDateTime);
    }

    @Test
    public void testPlus() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("current datetime = " + localDateTime);
        LocalDateTime updateTime = localDateTime.plusMonths(1);
        System.out.println("updateTime = " + updateTime);
    }


    @Test
    public void testAtOffset() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("系统当前时间" + localDateTime);
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime.toString());
    }


    @Test
    public void testAtZone() {
        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
//        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime.toString());
        System.out.println(zonedDateTime.getYear());
        System.out.println(zonedDateTime.getMonth());
        System.out.println(zonedDateTime.getDayOfMonth());
        System.out.println(zonedDateTime.getHour());
        System.out.println(zonedDateTime.getMinute());
        System.out.println(zonedDateTime.getSecond());
    }

    @Test
    public void testWithDayOfMonth() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(19);
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.withYear(2019);
        System.out.println(localDateTime2);
    }

    @Test
    public void getMonth() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Month month = localDateTime.getMonth();
        System.out.println("month = " + month);
        System.out.println("current month: " + localDateTime.getMonthValue());
    }

    @Test
    public void testUntil() {
        LocalDateTime localDateTime = LocalDateTime.now();
        long months = localDateTime.until(localDateTime.plusYears(1), ChronoUnit.MONTHS);
        System.out.println("months " + months);
        long days = localDateTime.until(localDateTime.plusYears(1), ChronoUnit.DAYS);
        System.out.println("days " + days);
    }

    @Test
    public void printAllTimeZones() {
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(availableZoneId);
        }
    }

    @Test
    public void testLocalDatetimeWithZone() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(localDateTime);

        final ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);

//        2021-08-19T22:54:54.481
//        2021-08-19T22:54:54.481+08:00[Asia/Shanghai]

    }


    @Test
    public void testIsBefore() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime beforeDateTime = localDateTime.minusHours(1);

        System.out.println(beforeDateTime.isBefore(localDateTime));

        System.out.println(beforeDateTime.isAfter(localDateTime));

    }

    @Test
    public void testIsLeapYear() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.isLeapYear());
    }




}
