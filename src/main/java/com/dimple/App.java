package com.dimple;

import java.util.EnumSet;

/**
 * Hello world!
 */
enum Season {
    SPRING, SUMMER, FAIL, WINTER
}

public class App {
    public static void main(String[] args) {
        //创建一个EnumSet的集合，集合元素就是season的全部枚举值
        EnumSet es1 = EnumSet.allOf(Season.class);
        System.out.println(es1);
    }
}
