package com.dimple.effectiveJava.chapter2;

import java.util.regex.Pattern;

/**
 * @className: Item6
 * @description: 避免创建不必要的对象
 * 一般来说，最好能够重用单个对象，而不是在每次需要的时候就创建一个功能相同的新对象。
 * 优先使用静态工厂方法而不是构造器，以避免创建不必要的对象。构造器在每次被调用的时候就会创建一个新的对象，而静态工厂方法重来不需要这样。
 * <p>
 * 要优先使用基本类型而不是装箱基本类型，要当心无意识的自动装箱
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item6 {
    //判断一个字符串是不是有效的罗马数字
    public static boolean isRomanNumeral(String s) {
        /**
         * 该方法的问题在于依赖于String.matchers方法，而这个方法不适合在注重性能的情形中重复使用。
         * 问题在于，它在内部创建了一个Pattern实例，却只用了一次，之后就被GC。而创建Pattern的成本很高，因此需要将正则表达式编译成为一个有限状态机（finite state machine)
         */
        return s.matches("(-| +|^)M{0,9}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})( +|$)");
    }

    private static final Pattern ROMAN = Pattern.compile("(-| +|^)M{0,9}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})( +|$)");

    /**
     * 如果改进后的方法的类被调用了，但是该方法没有调用，那么就没必要初始化ROMAN域，通过调用该方法的时候延迟初始化（lazily initializing)这个域，可能消除不必要的初始化工作，但是不建议
     * 这样做，这样做只会让方法的实现更复杂，从而无法将性能显著提高到超过已经达到的水平。
     */
    public static boolean isRomanNumeralNew(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i <= Integer.MAX_VALUE / 2; i++) {
            sum += i;
            System.out.println("in");
        }
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        start = System.currentTimeMillis();
        long sum1 = 0L;
        for (int i = 0; i <= Integer.MAX_VALUE / 2; i++) {
            sum1 += i;
        }
        System.out.println(sum1);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

