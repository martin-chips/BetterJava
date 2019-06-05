package com.dimple.effectiveJava.chapter4;

/**
 * @className: Item25
 * @description: 限制源文件为单个顶级类
 * 虽然Java编译器允许在一个源文件中定义多个顶级类，但这样没有好处，只会带来风险。因为源文件中定义多个顶级类，可能导致给一个类提供多个定义。哪一个定义被用到，取决于源文件传给编译器的顺序。
 * @auther: Dimple
 * @date: 06/05/19
 * @version: 1.0
 */
public class Item25 {
    public static void main(String[] args) {
        System.out.println(Utensil.NAME + Dessert.NAME);
    }

}

class Utensil {
    static final String NAME = "Pan";
}

class Dessert {
    static final String NAME = "pie";
}
