package com.dimple.java8.lambdaAndRef;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @className: MethodReferences
 * @description: 方法引用
 * 当要传递给Lambda表达式体的操作，已经有实现的方法了，就可以使用方法引用。
 * 方法引用可以看做是lambda表达式的更深层次的表达，换句话说，方法引用就是Lambda表达式，可就是函数式接口的一个实例，可以通过方法的名字来指向一个方法，可以认为是Lambda表达式的一个语法糖。
 * 要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致。
 * 使用格式： 类或者对象::方法名
 * <p>
 * 分为以下情况：
 * 1 对象::非静态防范
 * 2 类:: 静态方法
 * 3 类::非静态方法
 * <p>
 * 使用条件：
 * 接口中的抽象方法的形参列表和返回值类型与方法引用中的形参列表和返回值类型相同。
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class MethodReferences {

    public static void main(String[] args) {
        methodRef1();
        methodRef2();
        methodRef3();
    }

    /**
     * 对象::实例方法
     */
    public static void methodRef1() {
        //Lambda表达式写法
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("this is a lambda message");
        //方法引用写法（因为void println(String s)和Consumer中的 void accept(T t)的形参列表、返回值一样）
        Consumer<String> consumerMethodRef = System.out::println;
        consumerMethodRef.accept("this is a method reference message");

        //example 2
        String name = "Dimple";
        Supplier<String> stringSupplier = () -> name;
        System.out.println(stringSupplier.get());
        //方法引用：因为testMethodForMethodRef1的形参列表和返回值和get方法一致
        MethodReferences methodReferences = new MethodReferences();
        //这里使用的是对象调用非静态方法（对象只能调用非静态方法）
        Supplier<String> stringSupplierMethodRef = methodReferences::testMethodForMethodRef1;
        System.out.println(stringSupplierMethodRef.get());

    }

    private String testMethodForMethodRef1() {
        return "this is  a testMethod";
    }

    /**
     * 类::静态方法
     */
    public static void methodRef2() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(comparator.compare(1, 2));
        //方法引用：该方法和Integer里的静态方法Compare形参列表和返回值一致
        Comparator<Integer> comparatorMethodRef = Integer::compare;
        System.out.println(comparatorMethodRef.compare(1, 2));

        //example 2
        Function<Double, Long> function = (d) -> Math.round(d);
        System.out.println(function.apply(1D));
        //方法引用：和Math中的round方法形参列表和返回值一致
        Function<Double, Long> functionMethodRef = Math::round;
        System.out.println(functionMethodRef.apply(1D));
    }

    /**
     * 类::实例方法（非静态方法）
     */
    public static void methodRef3() {
        /**
         * 因为这里int compare(T o1, T o2); o1.compareTo(o2)，compare方法中的参数中的一个作为另一个方法的调用对象。
         */
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("abc", "abd"));

        Comparator<String> comparatorMethodRef = String::compareTo;
        System.out.println(comparatorMethodRef.compare("abc", "abd"));

        //       example2
        /**
         * boolean test(T t1,T t2)
         * String  boolean t1.equals(t2)
         */
        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        System.out.println(predicate.test("abc", "a"));

        BiPredicate<String, String> predicateMethodRef = String::equals;
        System.out.println(predicateMethodRef.test("abc", "a"));


        //example 3
        /**
         * String testMethodForMethodRef1()
         * s1.testMethodForMethodRef1()
         */
        Function<MethodReferences, String> function = (s1) -> s1.testMethodForMethodRef1();
        MethodReferences methodReference = new MethodReferences();
        System.out.println(function.apply(methodReference));
        Function<MethodReferences, String> functionMethodRef = MethodReferences::testMethodForMethodRef1;
        System.out.println(functionMethodRef.apply(methodReference));
    }

}
