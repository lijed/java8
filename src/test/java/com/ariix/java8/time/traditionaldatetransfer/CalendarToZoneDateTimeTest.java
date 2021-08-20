/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time.traditionaldatetransfer;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class CalendarToZoneDateTimeTest {

    @Test
    public void testZoneDateTimeToCalendar() {
        final GregorianCalendar from = GregorianCalendar.from(ZonedDateTime.now());
        final Date time = from.getTime();
        System.out.println("系统当前日期"+ time);
        System.out.println("时区： " + from.getTimeZone());
    }


    @Test
    public void testCalendarToZoneDateTime() {
        final Instant instant = GregorianCalendar.getInstance().toInstant();
        final ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
    }
}
