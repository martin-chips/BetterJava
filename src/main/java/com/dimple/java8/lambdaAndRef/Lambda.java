package com.dimple.java8.lambdaAndRef;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @className: Lambda
 * @description: Lambda表达式
 * -> Lambda操作符，左边为形参列表，右边为接口的实例（Lambda体）
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class Lambda {

    public static void main(String[] args) {
        method1();
        method2();
    }

    /**
     * Lambda表达式写法=====无参、无返回值
     */
    public static void method1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a test message");
            }
        };
        runnable.run();
        //lambda
        Runnable runnableLambda = () -> System.out.println("this is a lambda test message");
        runnableLambda.run();
    }

    /**
     * Lambda需要一个参数，但没有返回值
     */
    public static void method2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("this is a normal message");
        //Lambda
        Consumer<String> consumerLambda = (String s) -> System.out.println(s);
        consumerLambda.accept("this is a lambda message");
    }

    /**
     * 数据类型可以省略，因为可以由编译器推断得出
     */
    public static void method3() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("this is a normal message");
        //Lambda
        Consumer<String> consumerLambda = s -> System.out.println(s);
        consumerLambda.accept("this is a lambda message");
    }

    /**
     * Lambda若只需要一个参数，小括号可以省略
     */
    public static void method4() {
        Consumer<String> consumerLambda = s -> System.out.println(s);
        consumerLambda.accept("this is a lambda message");
    }

    /**
     * Lambda如果需要两个以上的参数，多条执行语句，并且有返回值
     */
    public static void method5() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
        System.out.println("normal :" + comparator.compare(1, 2));
        //Lambda
        Comparator<Integer> comparatorLambda = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        System.out.println("Lambda :" + comparatorLambda.compare(1, 2));
    }

    /**
     * 当Lambda只有一条语句的时候，return和大括号都可以省略
     */
    public static void method6(){
        Comparator<Integer> comparatorLambda = (o1, o2) -> Integer.compare(o1, o2);;
        System.out.println("Lambda :" + comparatorLambda.compare(1, 2));
    }

}
