package com.dimple.effectiveJava.chapter4;

/**
 * @className: Item23
 * @description: 类层次优于标签类
 * <p>
 * 面向对象的语言提供了其他更好的方法来定义能表示多种风格对象的单个数据类型：子类型化（subTyping）。标签类正是对类层次的简单效仿。
 * 为了将标签类转化为类层次，首先要为标签类中的每个方法定义一个包含抽象方法的抽象类。
 * @auther: Dimple
 * @date: 05/31/19
 * @version: 1.0
 */
public class Item23 {

}

/**
 * 以下类存在的问题：
 * 这是一个标签类；充斥着许多样板代码，包括枚举声明，标签域以及条件语句。优于多个实现乱七八糟的挤在单个类中，破坏了可读性。
 * 如果后面需要增加其他类型，就在case 后面增加。
 * 标签类过于冗长，容易出错，并且效率低下。
 * <p>
 * 修改：
 * 1. 在Figure类中，只有一个area方法，这个抽象类就是类层次的根，如果还有其他的方法其行为不依赖于标签的值，就把这个方法放在这个类中。同样的，如果所有的方法都用到了某些数据域，也应该把他们放在这个类中。
 * 2. 接下来需要为每一个原始标签都定义根类的具体子类。圆形（circle）和矩形（rectangle）
 */
class Figure {
    enum Shape {PECTANGLE, CIRCLE,}

    final Shape shape;
    double length;
    double width;

    double radius;

    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        shape = Shape.PECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case PECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError();
        }
    }
}

abstract class FigureNew {
    abstract double area();

    private int a = 10;


}

class Circle extends FigureNew {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends FigureNew {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}