package com.dimple.java8.streamAPI;

import com.dimple.java8.streamAPI.common.Dish;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: DishTest
 * @description:
 * @auther: Dimple
 * @date: 07/26/19
 * @version: 1.0
 */
public class DishTest {
    List<Dish> menu;

    @Before
    public void before() {
        menu = Dish.getMenu();
    }

    @Test
    public void testPredicate() {
        List<Dish> collect = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void getNum() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

}
