/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.stream.forkjoin;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/16
 **/
public class LongStreamExample {
    public static void main(String[] args) {
        Instant start = Instant.now();
        Long total = LongStream.rangeClosed(0, 10000000000L).parallel().sum();
        System.out.println("total = " + total);

        System.out.println("total spend seconds: " + Duration.between(start, Instant.now()));
    }
}
