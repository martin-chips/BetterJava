package com.dimple.effectiveJava.chapter6;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.Year;

/**
 * Java支持两种特殊用途的引用途径，一种是类，称为枚举类型；一种是接口，称为注解类型。
 *
 * @className: Item34
 * @description: 用enum代替int常量
 * 枚举类型（enum type） 是指由一组固定的常量组合成合法值的类型，例如一年之中的季节等。
 * <p>
 * Java提供了枚举类型来避免int和String的缺点。枚举类的本质是int。枚举类本质是单例的。
 * 枚举类型的基本思想：这些类通过共有的静态final域为每个枚举常量导出一个实例。枚举类型没有可以访问的构造器，所以是真正的final类。客户端不能创建出枚举类的实例，不能对它进行扩展，
 * 因此不存在实例，只存在申明过的枚举常量。
 * <p>
 * 枚举类保证了编译时的类型安全。
 * @auther: Dimple
 * @date: 06/06/19
 * @version: 1.0
 */
public class Item34 {
    /**
     * 以下方式也称为int枚举模型。首先int枚举模式不具备类型安全性，没有描述性。
     * 使用int枚举模型的程序是十分脆弱的。因为int枚举是编译时常量，他们的int值会被编译到客户端中，如果int枚举常量的值发生变化，需要重新编译。
     * 很难将int枚举常量转为可打印的字符串，当需要遍历枚举常量，获得枚举数组的大小时就会很无力。
     * <p>
     * 还有一种辩题，它使用的是String常量，这样的变体称为String枚举模式。
     */
    public static final int APPLE_FUJI = 0;
    public static final int APPLE_PIPPIN = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD = 2;


    public enum Apple {
        FUJI, PIPPIN, GRANNY_SMITH,
    }

    public enum Orange {
        NAVEL, TEMPLE, BLOOD,
    }


    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("454");
        double mass = earthWeight / Planet.MARS.getSurfaceGravity();
        for (Planet value : Planet.values()) {
            System.out.println(value);
        }

        System.out.println(Operation.MINUS.apply(10, 20));

        double x = 100;
        double y = 90;
        for (Operation value : Operation.values()) {
            System.out.printf("%f %s %f =%f%n", x, value, y, value.apply(x, y));
        }
    }
}

/**
 * 枚举类天生就是不可变的，因此所有的域都应该为final。
 * 所有的枚举类都一样，Planet有一个values方法，按照声明顺序返回它的值数组。
 */
enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869E+24, 6.052E6),
    MARS(6.419E+23, 3.393E6),
    ;
    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private final double G = 6.67300E-11;


    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}

/**
 * 将不同行为和每个枚举常量关联起来:
 * 在枚举类型中声明一个抽象的apply方法，并在特定于常量的类主题中，用具体的方法覆盖每一个常量的抽象apply方法。
 */
enum Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    }, MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    }, TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    }, DIBIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
}