/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time.traditionaldatetransfer;

import org.junit.Test;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class TimeZoneAndZoneIdTest {


    @Test
    public void testTimeZoneFromZoneId() {
        final TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(timeZone);
    }


    @Test
    public void testTimeZoneToZoneId () {
        final ZoneId zoneId = TimeZone.getTimeZone("Asia/Shanghai").toZoneId();
        System.out.println(zoneId);
    }
}
