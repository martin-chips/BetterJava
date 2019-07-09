package com.dimple.effectiveJava.chapter5;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @className: Item32
 * @description: 谨慎并用泛型和可变参数
 * @auther: Dimple
 * @date: 07/08/19
 * @version: 1.0
 */
public class Item32 {

    @SafeVarargs
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        T[] ts = toArray(a, c);
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError();
    }

    private String test = "test";

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
        String[] as = toArray("a");

        Item32 item32 = new Item32();

    }


}
