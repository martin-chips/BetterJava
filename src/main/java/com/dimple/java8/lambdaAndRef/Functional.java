package com.dimple.java8.lambdaAndRef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @className: Functional
 * @description: lambda表达式的本质：作为函数式接口的实例
 * 函数式接口：如果一个接口中，只声明了一个抽象方法，那么这个接口就是函数式接口
 * Java 内置的4大函数式接口
 * 消费型接口 Consumer<T>    void accept(T t)
 * 供给型接口 Supplier<T>    T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>   boolean test(T t)
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class Functional {

    public static void main(String[] args) {
        consumerFunctional();
        predicateFunctional();
    }

    /**
     * 消费型接口  accept()
     */
    public static void consumerFunctional() {
        consume(3, count -> System.out.println("消费 " + count + " 次"));
    }

    private static void consume(Integer count, Consumer<Integer> consumer) {
        consumer.accept(count);
    }

    public static void predicateFunctional() {
        List<String> list = Arrays.asList("Test1", "Test2", "Test3");
        System.out.println(filterString(list, s -> s.equals("Test1")).toString());
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    private static List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
