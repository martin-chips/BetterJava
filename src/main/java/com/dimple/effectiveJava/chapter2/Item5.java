package com.dimple.effectiveJava.chapter2;

import java.util.List;
import java.util.Objects;

/**
 * @className: Item5
 * @description: 优先考虑依赖注入来引用资源
 * <p>
 * 许多类会依赖一个或者多个底层的资源，一般都会将该类做成工具类或者单例。
 * 静态工具类和Singleton不适合需要引用底层资源的类。
 * 需要可以支持类的多个实例，每一个实例都可以使用客户端指定的资源。满足该需求的简单模式就是使用客户端指定的资源SpellChecker。
 * 这就是依赖注入（Dependency injection) 的一种形式，词典dictionary 就是SpellChecker的一个依赖，在创建SpellChecker的时候就注入。
 * <p>
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item5 {
}

//将其实现为静态工具类
class SpellCheckerUtil {
    //字典
    private static final String dictionary = "";

    private SpellCheckerUtil() {

    }

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String type) {
        return null;
    }
}

class SpellCheckerSingleton {
    //字典
    private static final String dictionary = "";

    private SpellCheckerSingleton() {

    }

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String type) {
        return null;
    }
}


class SpellChecker {
    private final String dictionary;

    SpellChecker(String dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String type) {
        return null;
    }
}