package com.dimple.effectiveJava.chapter4;

/**
 * @className: Item21
 * @description: 为后代设计接口
 * 在Java8 之前，如果不破坏现有的实现，是不可能给接口中添加方法的。如果给接口添加了一个新的方法，而实现中没有这个方法，就会导致编译错误。
 * 在Java8后，增加了缺省方法（default method）构造。目的是允许给接口添加方法。
 * 缺省方法的声明中包括了一个缺省实现（default implementation），这是给实现了该接口但没有实现默认方法的类使用的。
 * 有了缺省方法，接口中的方法不会出现编译时的报错和警告，但是可能会存在运行时失败的情况。
 * @auther: Dimple
 * @date: 05/31/19
 * @version: 1.0
 */
public class Item21 {

}


interface MyInterface {
    void test();

    default void test1() {
        System.out.println("this is a test");
    }
}