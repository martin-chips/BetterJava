package com.dimple.effectiveJava.chapter4;

/**
 * @className: Item16
 * @description: 要在公有类而非公有域中使用访问方法
 * 如果类在它所处的包之外访问，就提供访问方法。
 * Java平台类库中有几个类违反了“公有类不应该直接暴露数据域”的告诫，如java.awt中的Point类和Dimension类。
 * @auther: Dimple
 * @date: 05/28/19
 * @version: 1.0
 */
public class Item16 {

}

class Point {
    //do not do this
    /*public double x;
    public double y;*/

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
