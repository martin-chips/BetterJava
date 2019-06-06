package com.dimple.effectiveJava.chapter6;

/**
 * @className: Item35
 * @description: 用实例域代替序数
 * 许多枚举天生就与一个单独的int值相关联。所有的枚举都有一个ordinal方法，它返回每个枚举常量在类型中的数字位置。但是不要使用这个数字，因为当位置变化后，数字也会跟着变化。
 * 一般维护一个int的私有常量，将数字保存在实例域中。
 * @auther: Dimple
 * @date: 06/06/19
 * @version: 1.0
 */
public class Item35 {
}
