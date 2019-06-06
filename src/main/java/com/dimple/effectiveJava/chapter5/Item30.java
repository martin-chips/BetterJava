package com.dimple.effectiveJava.chapter5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @className: Item30
 * @description: 优先考虑泛型方法
 * 正如类可以从泛型中受益一般，方法也一样。静态工具方法尤其适用泛型化，Collections中所有的算法方法都被泛型化了。
 * @auther: Dimple
 * @date: 06/06/19
 * @version: 1.0
 */
public class Item30 {

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = new HashSet<>(Arrays.asList("Tom", "s", "Harry"));
        Set<String> stooges = new HashSet<>(Arrays.asList("Tom1", "1s", "H1arry"));
        Set<String> union = union(guys, stooges);
        System.out.println(union);
    }
}
