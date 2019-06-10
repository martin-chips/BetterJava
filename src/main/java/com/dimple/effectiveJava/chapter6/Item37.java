package com.dimple.effectiveJava.chapter6;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: Item37
 * @description: 用EnumMap代替序数索引
 * @auther: Dimple
 * @date: 06/10/19
 * @version: 1.0
 */
public class Item37 {
    public static void main(String[] args) {
        Set<Plant>[] plantsByLifeCycle = new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        Plant plant = new Plant("s", Plant.LifeCycle.ANNUAL);
        int ordinal = plant.lifeCycle.ordinal();
    }
}

class Plant {
    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL,
    }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
