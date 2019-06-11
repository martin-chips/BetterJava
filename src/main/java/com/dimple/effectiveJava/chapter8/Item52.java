package com.dimple.effectiveJava.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @className: Item52
 * @description: 慎用重载
 * 对于重载方法的选择是【静态】的，对于被覆盖的方法的选择是【动态】的。选择被覆盖的方法的正确版本是在运行时就进行的，选择的依据是被调用方法所在的对象的运行时类型，
 * @auther: Dimple
 * @date: 06/11/19
 * @version: 1.0
 */
public class Item52 {
    public static String classify(Set<?> set) {
        return "Set";
    }

    public static String classify(List<?> list) {
        return "List";
    }

    public static String classify(Collection<?> collection) {
        return "Collection";
    }

    public static void main(String[] args) {
        /**
         * 以下程序会打印出三次Collection，因为classify方法被重载了，而要调用哪个重载方法干是在编译时就做出决定的。在for循环中的三次迭代，参数的编译时类型都是相同的Collection<?>，每次迭代
         * 运行时类型不同，但这并不影响对重载方法的选择，因为编译时的类型为Collection<?>，所以合适的重载方法时classify(Collection<?>)
         */
        Collection<?>[] collections = {
                new HashSet<>(),
                new ArrayList<>(),
                new HashMap<String, String>().values()
        };
        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
//        =======================
        List<Wine> wineList = Arrays.asList(new Wine(), new SparkingWine(), new Champagne());
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }

}


class Wine {
    String name() {
        return "Wine";
    }
}

class SparkingWine extends Wine {
    @Override
    String name() {
        return "SparkingWine";
    }
}

class Champagne extends SparkingWine {
    @Override
    String name() {
        return "champagne";
    }
}