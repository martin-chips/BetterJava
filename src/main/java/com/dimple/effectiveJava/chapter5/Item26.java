package com.dimple.effectiveJava.chapter5;

import java.util.*;

/**
 * 从Java5开始，泛型（generic）已经成了Java编程语言的一部分，在没有泛型之前，从集合中读取到的每一个对象都必须要进行转换，如果不小心插入了类型错误的对象，在运行时就会出错。
 * 有了泛型后，就可以告诉编译器每个集合中接收哪些对象类型。编译器会自动为插入的对象进行转换，并在编译时告诉是否插入了类型错误的对象。
 *
 * @className: Item26
 * @description: 不要使用原生态类型
 * 泛型类和接口：声明中具有一个或者多个类型参数的类或者接口，就是泛型类或接口。List<E>就只有单个类型参数E，表示列表的元素类型。
 * 每一种泛型类型都定义了一个原生态类型（raw type），即不带任何实际类型参数的泛型名称，如List<E>对应的原生态类型时List。
 * 如果使用原生态类型就失去了泛型在安全性和描述性方面的所有优势。
 * 原生态类型的List和List<Object>的区别？
 * 前者逃避了类型安全性检查，后者则明确告诉编译器，能够支持任意类型的对象，虽然能够将List<String>传递给List的参数，但是不能将它传递给List<Object>的参数
 * <p>
 * 在不确定或者不在乎集合中元素的类型的情况下，使用原生态类型很危险，可以使用问号代替。例如Set<E>的无限制通配符类型为Set<?>。这是最普通的参数化Set集合，可以持有任何集合。
 * <p>
 * 不要使用原生态类型，以下几种情况除外：
 * 1. 必须在类文字中使用原生态类型：比如List.class和String[].class都是合法的，但是List<String>、List<?>不合法。
 * 2. 第二个与instanceof操作符有关，由于泛型信息在运行时被擦除，因此在参数化类型而非无限制通配符类型上使用instanceof操作符是非法的。用无限制通配符代替原生态类型，对instanceof操作符无影响。
 * @auther: Dimple
 * @date: 06/05/19
 * @version: 1.0
 */
public class Item26 {
    //do not do this
    private final Collection collections;
    //should replace by this
    private final Collection<String> collection;

    public Item26(Collection collections, Collection<String> collection) {
        this.collections = collections;
        this.collection = collection;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        System.out.println(strings.get(0));

        Collection collection = new HashSet();
        collection.add("ss");

        Object o = null;
        if (o instanceof Set) {
//            Set<?> set = (Set<?>) o;  right
            //一旦确定这个o是一个Set，就必须要转为Set<?> ，而不是转为原生态的Set，这个是一个受检异常，因此不会导致编译时警告。
            Set set = (Set) o;// error
        }
    }

    //    private static void unsafeAdd(List<String> strings, Integer valueOf) {
    private static void unsafeAdd(List strings, Integer valueOf) {
        strings.add(valueOf);
    }

    //    static int numElementsInCommon(Set s1<?>, Set s2<?>) {
    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }
}
