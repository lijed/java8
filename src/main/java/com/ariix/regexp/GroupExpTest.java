/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.ariix.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @Author: Administrator
 * Created: 2021/4/26
 **/
public class GroupExpTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("_(\\w)");
        String columnName = "aaaa_bb_cc";
        Matcher matcher = pattern.matcher(columnName);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
