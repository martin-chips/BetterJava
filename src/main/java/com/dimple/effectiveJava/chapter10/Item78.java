package com.dimple.effectiveJava.chapter10;

/**
 * @className: Item78
 * @description: 不要忽略异常
 * 空的catch块会使异常达到不应该有的目的。如果选择忽略异常，catch块中应该包含一条注释说明为什么可以这样，并将变量命名为ignored
 * @auther: Dimple
 * @date: 06/17/19
 * @version: 1.0
 */
public class Item78 {
    public void ignoreException() {
        try {
            //do some thing
        } catch (Exception ignored) {
            //why ignored exception
        }
    }
}
