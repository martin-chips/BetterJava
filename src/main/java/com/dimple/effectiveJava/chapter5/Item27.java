package com.dimple.effectiveJava.chapter5;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: Item27
 * @description: 消除非受检的警告
 * Set<Test> strings = new HashSet();这段代码是有警告的，需要使用Java7引入的菱形操作符：        Set<Test> strings = new HashSet<>();
 * 如果无法消除警告，同时可以证明引起警告的代码是足够安全的，可以使用注解 @SuppressWarnings("unchecked")来禁止警告。每当使用这条注解的时候，都需要添加一条注释，说明为什么这条
 * 代码是安全的。
 * @auther: Dimple
 * @date: 06/05/19
 * @version: 1.0
 */
public class Item27 {
    public static void main(String[] args) {

        @SuppressWarnings("unchecked")
        Set<Test> strings = new HashSet();
    }
}

class Test {

}
