/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.stream.forkjoin;

import lombok.SneakyThrows;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * Description:
 *
 * @Author: Jed li
 * Created: 2021/8/16
 **/
public class CalculationRecursiveTask extends RecursiveTask<Long> {

    private Long start, end;

    public CalculationRecursiveTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long length = end- start;
        if (length <= 100000) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        Long middle = (start + end) / 2;
        CalculationRecursiveTask left = new CalculationRecursiveTask(start, middle);
        left.fork();
        CalculationRecursiveTask right = new CalculationRecursiveTask(middle + 1, end);
        right.fork();
        return right.join() + left.join();
    }

    @SneakyThrows
    public static void main(String[] args) {
        //00 000 000 000
        Instant start =  Instant.now();
        CalculationRecursiveTask recursiveTask = new CalculationRecursiveTask(1L, 10000000000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //invoke 等待任务执行完成，获得结果
        forkJoinPool.invoke(recursiveTask);  //
//        forkJoinPool.submit(recursiveTask);
        System.out.println(recursiveTask.get());
//        forkJoinPool.shutdown();
        Instant end = Instant.now();

        long totalSpendMillis =  Duration.between(start, end).toMillis();
        System.out.println("totalSpendMillis = " + totalSpendMillis);

        //tradional way
        traditionWay();
    }


    public static void traditionWay () {
        Instant start =  Instant.now();
        long sum = 0;

        for (long i = 0; i < 10000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        Instant end  = Instant.now();
        System.out.println("totalSpendMillis = " + Duration.between(start, end).toMillis());
    }
}
