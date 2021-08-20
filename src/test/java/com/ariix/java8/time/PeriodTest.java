/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.java8.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/8/17
 **/
public class PeriodTest {

    @Test
    public void testPeriod() {
        LocalDate start = LocalDate.now();

        LocalDate end = start.plusMonths(1);
        Period period = Period.between(start, end);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
