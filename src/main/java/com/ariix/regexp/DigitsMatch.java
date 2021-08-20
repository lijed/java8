/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.regexp;

import java.util.regex.Pattern;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/6/2
 **/
public class DigitsMatch {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[\\d]*");
        if(p.matcher("963258").find()) {
            System.out.println("match");
        } else {
            System.out.println("unmatch");
        }

    }
}
