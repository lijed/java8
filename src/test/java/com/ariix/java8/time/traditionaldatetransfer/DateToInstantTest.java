/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time.traditionaldatetransfer;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class DateToInstantTest {
    /**
     * Date to instant
     */
    @Test
    public void testDateToInstant() {
        final Date time = Calendar.getInstance().getTime();
        final Instant instant = time.toInstant();
        System.out.println(instant);

        Date date = Date.from(Instant.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        System.out.println(date);

        testDateFromInstant();
    }


    /**
     * Date from Instant
     */
    @Test
    public void testDateFromInstant() {
        Date date;
        date = Date.from(Instant.now(Clock.system(ZoneId.of("America/Los_Angeles"))));
        System.out.println(date);
    }

    /**
     *
     */
    @Test
    public void testClock() {
        final Clock clock = Clock.system(ZoneId.of("America/Los_Angeles"));
        System.out.println(clock.instant());
    }
}
