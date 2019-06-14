package com.dimple.effectiveJava.chapter10;

/**
 * @className: Item70
 * @description: 对可恢复的情况使用受检异常、对于编程错误使用运行时异常
 * Java程序设计了三种可抛出结构：受检异常（checked exception）、运行时异常（runtime exception）和错误（error）。
 * 如果期望调用者能够适当的恢复，就应该使用受检异常，通过抛出受检异常，强迫调用者在catch中处理该异常，或者将他们传播出去。
 * 用运行时异常表示编程错误。
 *
 * 总而言之：对于可恢复的情况，要抛出受检异常；对于程序错误，要抛出运行时异常。如果不确定是否可恢复，就抛出未受检异常。
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item70 {
}
