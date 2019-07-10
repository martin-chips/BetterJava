package com.dimple.java8.lambdaAndRef;

import java.util.function.Function;

/**
 * @className: ArrayReferences
 * @description: 方法引用
 * 将数组看做为一个特殊的类，则和构造器引用一致
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class ArrayReferences {

    public static void main(String[] args) {
        ArrayRef1();
    }

    /**
     * 数组引用
     * Function中的R apply(T t)
     */
    public static void ArrayRef1() {
        Function<Integer, String[]> function = new Function<Integer, String[]>() {
            @Override
            public String[] apply(Integer integer) {
                return new String[integer];
            }
        };

        Function<Integer, String[]> functionLambda = integer -> new String[integer];
        System.out.println(functionLambda.apply(10).length);

        Function<Integer, String[]> functionArrayRef = String[]::new;
        System.out.println(functionArrayRef.apply(10).length);
    }

}
