package com.dimple.effectiveJava.chapter8;

/**
 * @className: Item53
 * @description: 慎用可变参数
 * 可变参数方法一般称作variable arity method，他可以接受0个或者多个指定类型的参数，可变参数机制首先会创建一个数组，数组的大小为在调用位置所传递的参数数量，然后将参数值传递到数组中，最后将数组传递给方法。
 *在重视性能的情况下，使用可变参数要特别小心。每次调用可变参数都会导致一次数组的分配和初始化。
 * @auther: Dimple
 * @date: 06/11/19
 * @version: 1.0
 */
public class Item53 {
}
