package com.dimple.effectiveJava.chapter9;

/**
 * @className: Item58
 * @description: for-each循环优于传统的for循环
 * for-each循环通过完全隐藏迭代器或者索引变量，避免了混乱和出错的可能。
 * 无法使用for-each的情况：
 * 1. 解析过滤——如果需要遍历集合，并且删除选定的元素，就需要使用显式的迭代器，以便可以调用它的remove方法。
 * 2. 转换——如果需要遍历列表或者数组，并取代它的部分或者全部元素值，就需要列表迭代器或者数组索引，以便设定元素的值。
 * 3. 平行迭代——如果需要并行的遍历多个集合，就需要显式的控制迭代器或者索引变量，以便所有的迭代器或者索引变量都可以同步前进。
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item58 {
    public void testForEach(int[] arr) {
        //for-each循环
        for (int i : arr) {

        }
    }
}
