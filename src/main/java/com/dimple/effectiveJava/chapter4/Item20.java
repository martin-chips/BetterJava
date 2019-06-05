package com.dimple.effectiveJava.chapter4;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * @className: Item20
 * @description: 接口优于抽象类
 * 接口是定义mixin（混合类型）的理想选择。mixin类型是指：类除了实现它的基本类型之外，还可以实现这个mixin类型，以表明它所提供了某些可供选择的行为。
 * 例如Comparable是一个mixin接口，它允许类表明它的实例可以与其他的可相互比较的对象进行排序。这样的接口称为mixin，是因为它允许任选的功能可被混合到类的主要功能中。
 *
 * 通过对接口提供一个抽象的骨架实现（skeletal implementation）类，可以把接口和抽象类的优点结合起来。接口负责定义类型，或许还提供一些缺省方法，而骨架实现类则负责实现除基本类型接口方法之外，剩下的非基本类型接口方法。
 * 按照惯例，骨架实现类被称为AbstractInterface，这里的interface是指所实现的接口的名称。例如实现了Collection接口的AbstractCollection、实现了Set接口的AbstractSet等。
 * @auther: Dimple
 * @date: 05/29/19
 * @version: 1.0
 */
public class Item20 {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public int size() {
                return a.length;
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldVal = a[index];
                a[index] = element;
                return oldVal;
            }
        };
    }
    public static void main(String[] args) {
    }
}
