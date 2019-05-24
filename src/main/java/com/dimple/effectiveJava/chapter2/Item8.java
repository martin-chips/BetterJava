package com.dimple.effectiveJava.chapter2;

/**
 * @className: Item8
 * @description: 避免使用终结方法和清除方法
 * 终结方法（finalizer）通常是不可预测的，也是很危险的，一般情况下也是不必要的。
 * 在Java9后用清除方法（cleaner）代替了终结方法。【清除方法没有终结方法那么危险，但仍然是不可预测、行动缓慢，一般情况下也是不需要的】
 * 终结方法和清除方法的缺点在于不能保证会被及时执行。从一个对象变得不可达开始，到它的终结方法被执行，所花费的时间是任意长的。则意味着，注重时间（time-critical）的任务不应该由
 * 终结方法或者清除方法来完成。
 * 终结方法有很严重的安全性问题：
 *
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item8 {
}
