package com.dimple.effectiveJava.chapter6;

import java.util.HashSet;
import java.util.Set;

/**
 * @className: Item40
 * @description: 坚持使用Override注解
 * Java类库中包含了几种注解类型，比如Override。这个注解只能用在方法声明中，表示被注解的方法声明覆盖了父类中的一个方法声明。
 * <p>
 * 在想要覆盖父类声明的每一个方法中使用Override注解：有一种情况例外，当在编写一个没有标注为抽象方法，并且确定已经完全覆盖了父类中的方法。这种情况就不必将Override注解方法放在该方法上，在没有
 * 覆盖父类的方法的情况下，编译器就会发出一个错误信息。
 * <p>
 * 使用Override注解来覆盖父类声明，编译器可以替你防止大量的错误，但有一个例外，在具体的类中，不必帮助你确定的抽象方法声明的方法。
 * @auther: Dimple
 * @date: 06/10/19
 * @version: 1.0
 */
public class Item40 {

}

/**
 * 主程序反复的将26个双字母组添加到集合中，每个双字母组都是由两个相同的小写字母组成。
 * 期待结果是26，但是结果是260
 * 以下操作并没有成功的覆盖equals方法，而是将它重载了。为了覆盖Object.equals必须要定义一个参数为Object类型的equals烦烦烦，但是Bigram类的equals方法的参数并不是object类型，因而Bigram类的从Object继承
 * 了equals方法。这个equals方法测试对象的同一性，就像==操作符一样。
 * 这个错误可以使用@Override得到提示。
 */
class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

/*    @Override
    public boolean equals(Bigram obj) {
        return obj.first == first && obj.second == second;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Bigram)) {
            return false;
        }
        Bigram b = (Bigram) obj;
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> bigrams = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                bigrams.add(new Bigram(ch, ch));
            }
        }
        System.out.println(bigrams.size());//result 260 expire 26
    }
}