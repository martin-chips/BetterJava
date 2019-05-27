package com.dimple.effectiveJava.chapter3;

/**
 * @className: Item13
 * @description: 谨慎覆盖clone
 * Clone 接口的目的是作为对象的一个minxin接口，表明这样的对象允许clone。遗憾的是，它并没有成功的达到这个目的，它的主要缺陷在于缺少一个clone方法，为Object 中的方法是受保护的。如果不借助反射
 * 就不能因为对象实现了Cloneable，就调用clone方法,即使调用也不一定会成功，因为不能保证该对象存在一个可访问的clone方法。
 * Cloneable没有包含任何一个方法，它的最庸在于决定了Object中受保护的clone方法的行为：
 * 如果一个类实现了cloneable，Object的clone方法就返回该对象的逐域拷贝，否则就会抛出CloneNotSupportException异常，这样改变了父类中受保护的方法的行为。
 * <p>
 * clone方法的约定：
 * 创建和返回一个拷贝。这个拷贝的精确含义取决于该对象的类，一般的含义是：对于任何对象x，表达式x.clone!=x将返回true，x.clone().getClass()==x.getClass()返回true。
 * 按照约定，返回的对象不依赖于被克隆的对象。
 * 如果域对象是final的，那么就不能clone，因为clone方法是禁止给final域赋值新值的。
 *
 * @auther: Dimple
 * @date: 05/27/19
 * @version: 1.0
 */
public class Item13 {
}
