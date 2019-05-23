package com.dimple.effectiveJava.chapter2;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @className: Item7
 * @description: 消除过期的对象引用
 * <p>
 * 清空对象引用应该是一种例外，而不是一种规范。消除过期引用最好的办法就是让包含该引用的变量结束其生命周期。只要类是自己管理内存，程序员就应该警惕内存泄露导致的问题，一旦元素被放掉，则该元素中包含的人任何对象
 * 引用都应该被清空。
 * <p>
 * 内存泄露的另一个常见来源是缓存
 * 如果要实现这样的缓存：只要在缓存之外存在某个项的键的引用，该项就有意义，那么可以用weakHashMap代表缓存；当缓存中的项过期后，就自动被删除。
 * 【只有当缓存的缓存项的生命周期由该键的外部引用而不是由值决定的时候，WeakHashMap才有用户】
 * <p>
 * 内存泄露的第三个来源是监听器和其他回调。如果实现了一个API，客户端在这个API中注册回调，却没有显式的被取消注册，除非采取某些动作，否则他们会不断的积累起来。
 * 确保回调立即被当做垃圾回收的追加方法是只保存他们的弱引用（weak reference）。
 *
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item7 {
}

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {

    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        /**
         * 此处可能存在“内存泄漏”，随着GC的进行，内存占用不断增加，程序性能降低，在极端的情况下，这种内存泄漏会导致磁盘交换（Disk Paging），导致OutOfMemory。
         *
         */
        // return elements[--size];
        //以下是正确方式
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
