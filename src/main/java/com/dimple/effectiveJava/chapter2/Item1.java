package com.dimple.effectiveJava.chapter2;

/**
 * @className: Item1
 * @description: 用静态工厂方法static factory method替代构造器（与设计模式中的工厂方法Factory Method不同）
 * <p>
 * 静态工厂与构造器的区别：
 * 1. 构造器有名称。如果构造器的参数本身没有确切的描述正在被返回的对象，那么具有适当名称的静态工厂方法更容易使用，产生的客户端代码更容易阅读。
 * 2. 不必在每次调用它们的时候都创建一个新对象。类似于Boolean.valueOf(boolean)。如果程序经常创建相同的对象，并且创建对象的代价很高，使用这项技术就可以提升性能。
 * 3. 可以返回原返回类型的任何子类型的对象。
 * 从Java8开始，接口中可以有共有静态方法；
 * 从Java9开始，接口中可以有私有静态方法，当静态域和静态成员仍然要求是共有的；
 * 4. 所返回的对象的类可以随着每次调用发生变化，这取决于静态工厂方法的参数值。只要声明的返回类型是其的子类型。
 * 5. 方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在。这种灵活的经验工厂方法构成了服务提供者框架（Service Provider Framework），如JDBC API。服务提供者框架是指
 * 这样一个系统：多个服务提供者实现一个服务，系统为服务提供者的客户端提供多种实现，并把他们从多个实现中解耦出来。
 *
 * <p>
 * <p>
 * 静态工厂的惯用名称：
 * from ——类型转换方法，只有一个单参数，返回该类型的相对应的实例：Date d = Date.from(instance)
 * of——聚合方法，带有多个参数，返回该类型的实例，把他们合并起来；
 * valueOf——比from和of更加繁琐的一种替代方法： BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
 * instance或者getInstance——返回的实例是通过方法的参数来描述的，但是不能说与参数具有同样的值。 StackWalker luke = StackWalker.getInstance(option)；
 * create或者newInstance——像Instance和getInstance一样，但是create或者newInstance可以确保每次调用都会返回一个实例：Object newArray=Array.newInstance(classObject,arrayLen);
 * <p>
 * 静态方法和共有构造方法都有用处，静态工厂通常更加适合。
 * @auther: Dimple
 * @date: 05/15/19
 * @version: 1.0
 */
public class Item1 {
    /**
     * 将boolean基本类型转换为一个对象
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Item1 instance(int type) {
        return type == 1 ? new ItemChild1() : new ItemChild2();
    }
}

class ItemChild1 extends Item1 {

}

class ItemChild2 extends Item1 {

}