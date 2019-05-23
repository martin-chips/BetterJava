package com.dimple.effectiveJava.chapter2;

/**
 * @className: Item4
 * @description: 通过私有构造器强化不可实例化的能力
 * 有时候需要编写只包含静态方法和静态域的类，这样的工具类utility class不需要被实例化，因为实例化没有任何意义，然而，在缺少显式的构造器的时候，编译器会自动添加一个公有的无参的构造器。
 * 让一个类包含一个私有的构造器，它就不能被实例化
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item4 {
    private Item4() {
        //Suppress default constructor for non-instantiable
        throw new AssertionError("the class can not been instance");
    }
}

