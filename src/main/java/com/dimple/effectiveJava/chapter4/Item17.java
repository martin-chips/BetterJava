package com.dimple.effectiveJava.chapter4;


/**
 * @className: Item17
 * @description: 使可变性最小化
 * 不可变类是指其实例不能被修改的类，每个实例中包含所有信息读必须在创建该实例的时候就提供，并在对象的整个生命周期类固定不变。比如String类、基本类型的包装类、BigInteger、BigDecimal。
 * 为了保证类不可变，需要遵循以下规则：
 * 1. 不要提供任何会修改对象状态的方法。
 * 2. 保证类不会被扩展。这样防止粗心或者恶意的子类假装对象的状态已经改变，从而破坏该类的不可变行为。为了防止子类化，一般是将其声明为final的。
 * 3. 声明所有域都是final的。
 * 4. 声明所有的域都是私有的。
 * 5. 确保对于任何可变组件的互斥访问。
 * <p>
 * 不可变对象本质上是安全的，他们不要求同步，因此不可变对象可以自由的被共享。不可变对象应该充分利用这种优势，尽可能的重用现有的实例：
 * 对于频繁用到的值，可以为他们提供公有的静态final常量。如下的ZERO等。
 * 同时可以使用静态工厂，将频繁使用的实例缓存起来。所有的基本类型的包装类和BigInteger都有这样的静态工厂。
 * <p>
 * 不仅可以共享不可变的对象，甚至可以共享它们的内部信息。
 * @auther: Dimple
 * @date: 05/28/19
 * @version: 1.0
 */
public class Item17 {
}

/**
 * 注意算术运算如何创建并返回新的Complex实例，而不是修改这个实例
 */
final class Complex {
    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex One = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    //public Complex(double re, double im) {
    //    this.re = re;
    //    this.im = im;
    //}

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex times(Complex c) {
        double temp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / temp, (im * c.re - re * c.im) / temp);
    }

    public Complex dividedBy(Complex c) {
        double temp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / temp, (im * c.re - re * c.im) / temp);
    }

}
