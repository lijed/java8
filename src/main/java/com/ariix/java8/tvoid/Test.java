package com.ariix.java8.tvoid;

import java.lang.reflect.Method;

public class Test {
    public void print(String v) {}

    public static void main(String args[]){
        for(Method method : Test.class.getMethods()) {
            if(method.getReturnType().equals(Void.TYPE)) {
                System.out.println(method.getName());
            }
        }
    }
}