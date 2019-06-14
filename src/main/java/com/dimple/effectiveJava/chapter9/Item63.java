package com.dimple.effectiveJava.chapter9;

/**
 * @className: Item63
 * @description: 了解字符串连接的性能
 * 为连接n各字符串而重复的使用+号，需要n的平方级的时间。这是由于字符串不可变导致的结果。当两个字符串被连接在一起，他们的内容都要拷贝.
 *
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item63 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("total " + (end - start));

        start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder total " + (end - start));

        /**
         * total 411
         * StringBuilder total 0
         */
    }
}
