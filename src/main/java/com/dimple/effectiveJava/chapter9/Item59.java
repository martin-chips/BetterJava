package com.dimple.effectiveJava.chapter9;

import java.util.Random;

/**
 * @className: Item59
 * @description: 了解和使用类库
 *
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item59 {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
