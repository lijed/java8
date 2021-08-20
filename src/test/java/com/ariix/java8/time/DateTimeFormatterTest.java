/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Description:
 *
 * @Author: Jed li
 * Created: 2021/8/17
 **/
public class DateTimeFormatterTest {

    @Test
    public void testDateTimeFormatterWithThreadLocalSimpleDateformatter() throws ExecutionException, InterruptedException {
        //Parse的日期不对
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = ()-> ThreadLocalDateFormatter.formatDate("20201202");

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Date>> futureLIst = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            futureLIst.add( service.submit(task));
        }

        for (Future<Date> dateFuture : futureLIst) {
            System.out.println(dateFuture.get());
        }

    }


    @Test
    public void testDateTimeFormatterWithSimpleDateformatter() throws ExecutionException, InterruptedException {
        //Parse的日期不对
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Callable<Date> task = ()-> simpleDateFormat.parse("20210602");

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<Date>> futureLIst = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            futureLIst.add( service.submit(task));
        }

        for (Future<Date> dateFuture : futureLIst) {
            System.out.println(dateFuture.get());
        }

    }

    //线程安全的
    @Test
    public void testDateTimeFormatter() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = ()-> LocalDate.parse("20201202", dateTimeFormatter);

        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future> futureLIst = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            futureLIst.add( service.submit(task));
        }


        futureLIst.forEach(future -> {
            try {
                System.out.println(future.get()) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }


    @Test
    public void testDateTimeFormatter1() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        final String dateTimeStr = localDateTime.format(formatter);
        System.out.println(dateTimeStr);

        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
    }


    @Test
    public void testCustomerDatetimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(LocalDateTime.now().format(formatter));
    }


}
