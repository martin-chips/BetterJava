package com.dimple.effectiveJava.chapter6;

import java.util.EnumSet;
import java.util.Set;

/**
 * @className: Item36
 * @description: 使用EnumSet代替位域
 * JavaUtil包提供了EnumSet方法来有效的表示单个枚举类型中提取多个值的多个组合。
 * 这个类实现了Set接口，提供了丰富的功能，类型安全性，以及可以从其他Set实现中得到互用性。
 * @auther: Dimple
 * @date: 06/06/19
 * @version: 1.0
 */
public class Item36 {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    public enum Style {BOLD, ITALIC, UNDERLINE, STRINERHROUGH,}

    public void applyStyles(Set<Style> styles) {

    }

    public void applyStyle(int style) {
        //do other things
        System.out.println(style);
    }

    public static void main(String[] args) {
        Item36 item36 = new Item36();
        item36.applyStyles(EnumSet.of(Style.UNDERLINE, Style.ITALIC));

        //|表示按位逻辑或
        item36.applyStyle(STYLE_ITALIC | STYLE_UNDERLINE);
    }
}
