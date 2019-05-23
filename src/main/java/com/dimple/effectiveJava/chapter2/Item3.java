package com.dimple.effectiveJava.chapter2;

/**
 * @className: Item3
 * @description: 用私有构造器或者枚举类型清华Singleton属性
 * Singleton是指只被实例化一次的类，通常被用于代表一个无状态的对象。
 * <p>
 * 实现Singleton的方法都需要私有构造器，并导出共有的静态成员，确保他们可以被访问。
 * <p>
 * 为了将利用上述方法实现的Singleton类变成可序列化的（Serializable），仅仅在声明中加上implements Serializable是不够的。为了维护并保证Singleton，必须声明所有实例域都是瞬时的transient，并提供一个readResolve
 * 方法，否则，每次反序列化一个序列化实例时，都会创建一个新的实例。
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item3 {
    public static void main(String[] args) {
        Elvis instance = Elvis.INSTANCE;
    }
}

//Singleton with public final field
//公有域的主要优势在于，API可以很清楚的表明这个类是一个Singleton；其次更简单
class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    //客户端可能会通过反射的方式，使用AccessibleObject.setAccessible方法调用私有构造器。解决办法，可以在创建第二个实例的时候抛出异常
    private Elvis() {

    }

    //ReadResolve method to preserve singleton property
    private Object readResolve() {
        //Return the one true Elvis and let the garbage collector take care of the Elvis impersonator
        return INSTANCE;
    }
}

//Singleton with static factory method

/**
 * 静态工厂的优势在于：
 * 1 提供了灵活性：在不改变API的前提下，可以改变该类是否为Singleton的想法，很容易被修改
 * 2 如果应用程序需要，可以编写成一个泛型的Singleton工厂(generic singleton factory)
 * 3 可以通过方法引用作为提供者
 */
class Elvis2 {
    private static Elvis2 INSTANCE = new Elvis2();

    public static Elvis2 getINSTANCE() {
        return INSTANCE;
    }
}
