package com.dimple.effectiveJava.chapter5;

import java.util.Arrays;
import java.util.List;

/**
 * @className: Item28
 * @description: 列表优于数组
 * 泛型和数组相比，有两个重要的不同点：
 * 1. 数组是协变的，表示如果Sub是Super的子类型，那么数组Sub[] 就是Supper[]的子类型。而泛型是可变的：对于任意两个不同类型的Type1和Type2，List<Type1>既不是List<Type2>的子类型，也不是List<Type2>的父类型。
 * 2. 数组是具体化的。数组会在运行时就知道他们的元素类型。相比之下，泛型是通过擦除来实现的，则意味着，泛型只是编译时情况他们的类信息，并在运行时丢弃他们的元素类型信息。
 * @auther: Dimple
 * @date: 06/05/19
 * @version: 1.0
 */
public class Item28 {
    public static void main(String[] args) {
        /**
         * 以下两种方法，都不能将String装到Long的容器中，但是利用数组，只能在运行的时候发现错误，而利用列表，就可以在编译的时候发现错误。
         */
        // fail at runtime
        Object[] objectArray = new Long[1];
//        objectArray[0] = "I dont's fit in it";
        //won't be compile
//        List<Object> objects = new ArrayList<Long>();
//        objects.add("I dont's fit in it");


        List<String>[] stringList = new List[1];
        List<Integer> intList = Arrays.asList(52);
        Object[] objects = stringList;
        objects[0] = intList;
        String s = stringList[0].get(0);
    }
}
