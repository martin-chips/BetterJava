package com.dimple.effectiveJava.chapter4;

/**
 * @className: Item22
 * @description: 接口只用于定义类型
 * 当类实现接口时，接口就充当可以应用这个类的实例的类型（type）。因此，类实现了接口，就表明客户端可以对这个类的实例实施某些动作。
 * 在一种接口被称为常量接口（constant interface）.常量接口是对接口的不良使用。类在内部使用某些常量，完全属于实现吸细节，实现常量接口会导致将这样的实现细节泄露到该类的导出API中。反面例子：ObjectStreamConstants
 * 如果要导出常量的几个合理的选择方案：
 * 1. 如果这些常量与某个现有的类或者接口紧密相关，应该将这些常量添加到类或者接口中。如Integer.MAX_VALUE常量。
 * 2. 如果这些常量最好被看做枚举类型的成员，应该使用枚举类型（enum type）来导出这些常量。
 * 3. 使用不可实例化的工具类来导出这些常量
 * @auther: Dimple
 * @date: 05/31/19
 * @version: 1.0
 */
public class Item22 {
}

interface PhysicalConstants {
    double AVOGADROS_NUMBER = 22;
}

class PhysicalConstantsClass {
    //prevents instantiation
    private PhysicalConstantsClass() {
    }

    public static double AVOGADROS_NUMBER = 22;
}
