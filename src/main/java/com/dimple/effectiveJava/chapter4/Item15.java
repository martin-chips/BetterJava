package com.dimple.effectiveJava.chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @className: Item15
 * @description: 使类和成员的可访问性最小化
 * 设计良好的组件会隐藏所有实现的细节，把API和实现清晰地隔离开来。然后组件之间只通过API进行通信，一个模块不需要其他模块的内部工作情况，这就是信息隐藏或封装，是软件设计的基本原则之一。
 * 对于顶层的类和接口，只有两种可能的访问级别：包级私有的（package-private）和公有的（public）。
 * 1. 私有的（private）一－只有在声明该成员的顶层类内部才可以访问这个成员。
 * 2. 包级私有的（package-private）一一声明该成员的包内部的任何类都可以访问这个成员。从技术上讲，它被称为“缺省”（ default ）访问级别，如果没有为成员指定访问修饰符，就采用这个访问级别（当然，接口成员除外，它们默认的访问级别是公有的）。
 * 3. 受保护的（protected ）一一声明该成员的类的子类可以访问这个成员，并且声明该成员的包内部的任何类也可以访问这个成员。
 * 4. 公有的（public)－一在任何地方都可以访问该成员。
 * 一般而言，私有类和私有成员是类的实现的一部分，一般不会影响导出的API。但是如果这个类实现了Serializable接口，这个域可能被泄露（leak）到导出的API中。
 * 如果方法覆盖了父类中的一个方法，子类的访问级别不允许低于父类中的访问级别。【这样可以确保在需要使用父类实例的地方也可以使用子类的实例】
 * <p>
 * 公有类的实例决不能是公有的。如果实例域是非final的，或者是一个指向可变对象的final引用，一般这个域称为公有的，就等于放弃了对存储在这个域中的值进行限制的能力；
 * @auther: Dimple
 * @date: 05/28/19
 * @version: 1.0
 */
public class Item15 {
    private static final String[] STRINGS = {"", ""};
    //将数组变成私有的，然后增加一个公有的不可变列表
    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(STRINGS));

    //返回数组对象的Clone
    public static final String[] VALUES() {
        return STRINGS.clone();
    }

    public static void main(String[] args) {
    }
}
