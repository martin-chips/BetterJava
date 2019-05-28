package com.dimple.effectiveJava.chapter3;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @className: Item14
 * @description: 考虑实现Comparable接口
 * CompareTo方法并没有在Object中，它是Comparable接口中唯一的方法。compareTo方法不但允许进行简单的等同性比较，而且允许执行顺序的比较，除此之外，它域Object的equals方法具有相似的特征，它还是泛型。
 * 类实现了comparable接口，就表明它的实例具有内在的排序关系。
 * 为实现了Comparable接口的对象数组进行排序：Arrays.sort(a)
 * 对存储在集合中的Comparable对象进行搜索、计算极限值以及自动维护也同样简单。
 * 一旦实现了comparable接口，它就可以跟许多泛型算法（generic algorithm）以及依赖该接口的集合实现（collection implementation）进行协作。
 * 事实上，JAVA平台类库中所有的值类（value classes），以及所有的枚举类型都实现了Comparable接口。
 * <p>
 * compareTo这个方法与equals方法的约定相似：
 * 将这个对象与指定的对象进行比较。当该对象小于、等于、大于指定对象的时候，分别返回一个负整数、零或者正整数。如果指定的对象无法与该对象进行比较，则抛出ClassCastException。
 * <p>
 * 在下面的说明中，符号sgn(expression)表示数学中的signum函数，它根据表达式的值为负值、零、正值，分别返回-1、0、1.
 * 1. 需要确保x和y都满足sgn(x.compareTo(y))==-sgn(y.compareTo(x))，这也意味着当y.compareTo(x)抛出异常，那么x.compareTo(y)也应该抛出异常。
 * 2. 确保关系可传递：x.compareTo(y)>0&&y.compareTo(z)>0，必然有x.compareTo(z)>0
 * 3. 确保x.compareTo(y)==0,暗示着sgn(x.compareTo(z)==sgn(y.compareTo(z))
 * <p>
 * 就好像违反hashcode约定会破坏依赖于散列的类一样，违反compareTo约定的类也会破坏其他具有比较关系的类。依赖于比较关系的有序集合类treeSet和treeMap，以及工具类Collections和Arrays，他们内部包含有搜索和排序算法。
 * <p>
 * CompareTo方法中域的比较是顺序的比较，而不是等同性的比较。比较对象引用域可以通过递归的调用compareTo方法实现。如果一个域并没有实现comparable接口，或者需要一个非标准的排序关系，
 * 可以显式的用一个Comparator来代替。
 * <p>
 * 一般使用如下方式 Comparable<Item14>，防止ClassCastException。
 * 在Java7后，所有的Java的装箱基本类型都增加了静态的compare方法，在compareTo中使用关系操作符<>是比较繁琐的，不再建议使用。
 * @auther: Dimple
 * @date: 05/27/19
 * @version: 1.0
 */
public class Item14 implements Comparable<Item14> {
    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>();
        String[] values = {"I ", "AM ", "A ", " BOY"};
        Collections.addAll(strings, values);
        System.out.println(strings);
        testBigDecimal();
    }

    /**
     * BigDecimal类的CompareTo方法和equals方法是不一致的。如果使用HashSet装以下两个数，那么会显示两个，而如果用TreeSet会只有一个。因为TreeSet比较的时候是采用CompareTo
     */
    public static void testBigDecimal() {
        System.out.println("======================");
        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1.00");

        System.out.println("equals :" + bigDecimal1.equals(bigDecimal2));

        HashSet hashSet = new HashSet();
        hashSet.add(bigDecimal1);
        hashSet.add(bigDecimal2);
        System.out.println("hashset size " + hashSet.size());

        TreeSet treeSet = new TreeSet();
        treeSet.add(bigDecimal1);
        treeSet.add(bigDecimal2);
        System.out.println("treeSet size " + treeSet.size());

    }

    @Override
    public int compareTo(Item14 o) {
        return 0;
    }
}

class TestComparator {
    private int number;
    private double price;

    private static final Comparator<TestComparator> COMPARATOR = Comparator.comparingInt((TestComparator test) -> test.number)
            .thenComparingDouble((TestComparator test) -> test.price);

    public int compare(TestComparator test) {
        return COMPARATOR.compare(this, test);
    }
}