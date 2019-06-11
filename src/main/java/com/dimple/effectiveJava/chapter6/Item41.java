package com.dimple.effectiveJava.chapter6;

/**
 * @className: Item41
 * @description: 用标记接口定义类型
 * 标记接口（marker interface)是不包含方法声明的接口。它只是标明一个类实现了具有某种属性的接口。比如Serializable接口，通过实现这个接口，类表明它的实例可以被写到ObjectOutputStream中。
 * 标记注解可以标记接口已经过时了，标记接口有两点胜过标记注解，首先，标记接口定义的类型是由被标记类的实例实现的；标记注解则没有定义这样的类型。标记接口的存在，允许在编译时就捕捉到在使用标记注解的情况下需要
 * 运行才能捕捉到的错误。
 * Java的序列化设计利用Serializable标记接口标明一个类型是可以序列化的，ObjectOutputStream.writeObject方法干将传入的对象序列化，其参数必须是可序列化的。该方法的参数应该是SERIALIZABLE类型的，如果试着
 * 序列化一个不恰当的对象，通过类型检查，在编译时就应该被发现。编译时的错误侦测是标记接口的目的，但是ObjectOutputStream并没有利用接口的优势，其参数声明为Object类型，因此，如果尝试序列化一个不可序列化的对象，
 * 直到运行时才会失败。
 * 标记接口胜过标记注解的另一个优点是，他们可以被更加精确地进行锁定。如果注解类型用目标ElementType.TYPE声明，它就可以被应用于任何类和接口。
 * @auther: Dimple
 * @date: 06/10/19
 * @version: 1.0
 */
public class Item41 {
    public static void main(String[] args) {

    }
}
