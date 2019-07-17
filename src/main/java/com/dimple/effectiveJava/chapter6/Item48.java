package com.dimple.effectiveJava.chapter6;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @className: Item48
 * @description: 谨慎使用Stream并行
 * @auther: Dimple
 * @date: 07/15/19
 * @version: 1.0
 */
public class Item48 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(pi(8));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        System.out.println(piNew(8));
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static long piNew(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
