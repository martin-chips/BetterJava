package com.dimple.effectiveJava.chapter10;

/**
 * @className: Item75
 * @description: 在细节消息中包含失败-捕获信息
 * 当程序由于未被捕获的异常而失败的时候，系统会自动打印出该异常的堆栈轨迹，在堆栈中包含该异常的字符串表示法（string representation），即它的toString方法的调用结果。
 * 它通常应该包含该异常的类名，紧接其后是细节消息（detail message）。
 * 为了捕获失败，异常的细节应该包含“对该异常有贡献”的所有参数和域的值。不要在堆栈信息中包含密码、秘钥以及类似的信息。
 * @auther: Dimple
 * @date: 06/17/19
 * @version: 1.0
 */
public class Item75 {
}
