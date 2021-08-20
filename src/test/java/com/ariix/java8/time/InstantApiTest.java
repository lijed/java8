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
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

/**
 * Instant： 时间戳（以Unix元年： 1970年1月1日00:00:00到某个时间之间的毫米值）
 *
 * @Author: Jed Li
 * Created: 2021/8/17
 **/
public class InstantApiTest {


    @Test
    public void test() {
        Instant instant = Instant.now(); //默认为UTC
        // 默认的时间是UTC的时间
        System.out.println(instant);
        System.out.println(instant.get(ChronoField.MILLI_OF_SECOND));

        //中国时间
        OffsetDateTime chinaOffsetDatetime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("中国时间" + chinaOffsetDatetime);

        OffsetTime offsetTime = OffsetTime.now();
        OffsetTime offsetTime1 = offsetTime.withOffsetSameLocal(ZoneOffset.ofHours(8));
        System.out.println(offsetTime1);
    }

    @Test
    public void testInstantWithSecond() {
        //以Unix元年： 1970年1月1日00:00:00到某个时间之间的毫米值
        Instant instant = Instant.ofEpochSecond(1000);
        System.out.println(instant);
    }


    @Test
    public void testDuration() throws InterruptedException {
        Instant start = Instant.now();
        TimeUnit.SECONDS.sleep(10);
        Duration duration = Duration.between(start, Instant.now());
        System.out.println("duration: " + duration);
        Long secondDurations = duration.getSeconds();
        System.out.println("seconds: " + secondDurations);
        System.out.println("nanoseconds: " + duration.getNano());
    }
}
