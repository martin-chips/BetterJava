package com.dimple.effectiveJava.chapter8;

import lombok.Data;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @className: Item55
 * @description: 谨慎返回optional
 * 在Java8之前，要编写一个特定环境下无法返回任何值的方法时，要么抛出异常、要么返回null。异常应该根据异常条件保留起来（Item69）。由于创建会捕获整个堆栈轨迹，因此抛出异常的开销很大。
 * 返回null要求客户端调用的时候处理可能返回null的情况，否则会出现NullPointException。
 * 在Java8之中，还有第三种方法。Optional<T>类代表的是一个不可变的容器，它可以存放单个非Null的T引用，或者什么内容都没有。不包含任何内容的optional称为空empty。非空的optional中的值称为存在present。
 * optional本质上是一个不可变的集合，最多存放一个元素。
 * optional.empty()返回一个空的optional，Optional.of(value)返回一个指定非null的optional，将null传入Optional.of(value)方法会抛出NPE。
 * 如果方法返回optional，客户端就必须要做出选择，如果该方法不能返回值时应该做什么操作，或许可以指定一个缺省值orElse，或者抛出任何适当的异常orElseThrow。
 * 有时候，获取缺省值的开销很高，除非有必要，否则还是希望避免这个开销，Optional类提供了一个orElseGet方法，这个方法不会像orElse方法每次都要执行。
 * 还有一个isPresent方法，当optional中包含有值的时候返回true。
 * <p>
 * 并非所有的返回类型都受益于optional的处理方法。【容器类型包括集合、映射、Stream、数组和Optional，都不应该被包装在optional中。】不要返回空的optional<List<T>>，而应该只返回一个空的List<T>
 *
 * @auther: Dimple
 * @date: 06/13/19
 * @version: 1.0
 */
public class Item55 {

    public static void main(String[] args) {


    }

    /**
     * 对象创建
     *
     * @param string
     */
    public static final void createObject(String string) {
        //创建空对象
        Optional<String> optStr = Optional.empty();//调用empty创建了一个空的Optional<String>对象。
        //创建对象：不允许为空
        Optional<String> optStrNonNull = Optional.of(string);//Optional提供了of方法用于创建非空对象，该方法要求传入的参数不能为空，否则抛出NullPointException。
        //创建对象：允许为空
        Optional<String> optStrNull = Optional.ofNullable(string);//如果不能确定传入的参数是否存在null的可能性，则可以使用Option的ofNullable方法创建对象，如果入参为null，就创建一个空对象。
    }
}
