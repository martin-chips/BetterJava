package com.dimple.effectiveJava.chapter9;

/**
 * @className: Item65
 * @description: 接口优于反射机制
 * 核心反射机制提供了程序来访问任意类的能力，给定一个Class对象，可以获取Constructor、Method和Field实例。
 * 例如Method.invoke可以调用任何对象上的任何方法。反射机制允许一个类使用另一个类，即使当前者被编译的时候后者还根本不存在，当然存在以下缺陷：
 * 1. 损失了编译时类型检查的优势。
 * 2. 执行反射访问所需要的代码比较笨拙和冗长。
 * 3. 性能损失。
 *
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item65 {
}
