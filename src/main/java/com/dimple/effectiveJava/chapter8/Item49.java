package com.dimple.effectiveJava.chapter8;

import java.math.BigInteger;
import java.util.Objects;

/**
 * @className: Item49
 * @description: 检查参数的有效性
 * 对于共有或者受保护的方法，要用javadoc的@Throws标签（tag）在文档中说明违反参数限制时抛出的异常。这样的异常通常为IllegalArgumentException、IndexOutOfBoundsException、NullPointerException。
 * 在Java7中增加了Objects.requireNonNull方法可以对参数进行检查。
 * 在Java9中增加了范围检查的方法：checkFromIndexSize、checkFromToIndex、checkIndex。
 * 对于未导出的方法，作为包的创建者，可以控制这个方法哪些时候被调用，因此可以确保只将有效的参数传递进来，因此，非公有方法应该使用断言(assertion)来检查参数,使用-enableassertions开启断言检查。
 * @auther: Dimple
 * @date: 06/11/19
 * @version: 1.0
 */
public class Item49 {
    /**
     * @param m
     * @return
     * @throws ArithmeticException if m is less than or equal 0
     */
    public BigInteger mod(BigInteger m) {
        Objects.requireNonNull(m, "is null");
        if (m.signum() <= 0) {
            throw new ArithmeticException("Modules <=0 " + m);
        }
        return null;
    }

    private static void sort(long[] a, int offset, int length) {
        assert (a == null);
        assert offset >= 0 && offset <= a.length;
    }

    public static void main(String[] args) {
        try {
            sort(null, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }
}
