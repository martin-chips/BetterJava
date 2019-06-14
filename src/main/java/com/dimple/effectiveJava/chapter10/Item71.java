package com.dimple.effectiveJava.chapter10;

/**
 * @className: Item71
 * @description: 避免不必要的使用受检异常
 * 过分的使用受检异常会使得API调用非常不方便，因为它强迫程序员对其进行处理。
 * 总而言之：在谨慎使用的前提下，受检异常可以提升程序的可读性；如果使用过度，就会使API使用起来非常痛苦。如果调用者无法恢复失败，就应该抛出受检异常，如果可以恢复
 * ，并且想要迫使调用者处理异常的条件，首选应该返回一个optional。
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item71 {
}
