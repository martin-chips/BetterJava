package com.dimple.effectiveJava.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @className: Item33
 * @description: 优先考虑类型安全的异构容器
 * @auther: Dimple
 * @date: 07/09/19
 * @version: 1.0
 */
public class Item33 {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorites(String.class, "Java");
        favorites.putFavorites(Integer.class, 1);
        favorites.putFavorites(Class.class, Favorites.class);
        String string = favorites.getFavorites(String.class);
        Integer integer = favorites.getFavorites(Integer.class);
        Class aClass = favorites.getFavorites(Class.class);
        System.out.println(string);
        System.out.println(integer);
        System.out.println(aClass);
    }
}

class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}