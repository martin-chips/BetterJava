package com.dimple.effectiveJava.chapter4;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @className: Item18
 * @description: 复合优先于继承
 * 与方法调用不同的是，继承打破了封装性。子类都依赖于父类特定功能的实现细节。
 * 如果覆盖了父类的方法，而父类的方法很可能是自用的，这种覆盖父类的方法来实现子类的功能，很容易实现困难，耗时、效率低下等。而且如果父类在后续增加的方法中有子类已经写好的方法，可能导致覆盖，导致子类编译出错。
 * <p>
 * 不扩展现有的类，而是在新的类中增加一个私有域，这种方式称为复合，因为现有的类变成了新类的一个组件。新类中的方法称为转发方法。这样得到的类将非常稳固，它不依赖于现有类的实现细节，即使现有的类增加了新的方法，也不会影响到新的类。
 * @auther: Dimple
 * @date: 05/28/19
 * @version: 1.0
 */
public class Item18 {
    public static void main(String[] args) {
        InstrumentedHashSet<String> strings = new InstrumentedHashSet<>();
        strings.addAll(Arrays.asList("ss0", "ss1", "ss2"));
        /*
        之所以结果为6，是因为这个addAll底层是调用的add方法实现的。
         */
        System.out.println(strings.getAddCount());//result 6

        //    =================

    }
}

class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {

    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

/**
 * 定义一个转发类
 *
 * @param <E>
 */
class ForwordingSet<E> implements Set<E> {
    private final Set<E> set;

    public ForwordingSet(Set<E> set) {
        this.set = set;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }
}

/**
 * InstrumentSet实现了Set接口，并且拥有单个构造器，它的参数也是Set类型，从本质上讲，这个类吧一个Set转变成为了另一个Set，同时增加了计数的功能。这里的包装类可以用来包装任何Set的实现，并且可以和先前存在的构造器一起工作。
 *
 * @param <E>
 */
class InstrumentSet<E> extends ForwordingSet<E> {
    private int addCount = 0;

    public InstrumentSet(Set<E> set) {
        super(set);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}