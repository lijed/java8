/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time.traditionaldatetransfer;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/20
 **/
public class TestTimeStampToInstant {


    @Test
    public void testTimeStampToInstant() {
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);

        final Instant instant = timestamp.toInstant();
        System.out.println(instant);

        final LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println(localDateTime);
    }

    @Test
    public void testInstantToTimeStamp() {
        Instant instant = Instant.now();
        final Timestamp from = Timestamp.from(instant);
        System.out.println(from);
    }
}
