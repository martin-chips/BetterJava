package com.dimple.effectiveJava.chapter5;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * @className: Item31
 * @description: 利用有限制通配符来提升API的灵活性
 * 参数化类型是不可变的。换句话说，对于任何两个截然不同的类型Type1和Type2而言，List<Type1>既不是List<Type2>的子类型，也不是它的父类。
 * <p>
 * Java提供了一种特殊的参数化类型，称为有限制的通配符类型，它可以处理pushAll的情况，pushAll的输入参数类型不应该为“E的Iterable接口”，而应该为“E的某个子类型的Iterable接口”通配符类型。
 * <p>
 * 为了获得最大限度的灵活性，要在表示生产者或者消费者的输入参数上使用通配符类型。
 * 以下助记符方便记住要使用哪种通配符类型：PECS:producer-extends，consumer-super。
 * 如果一个参数化类型表示一个生产者T，那么就是用<? extends T>;如果表示一个消费者，就采用<? super T>
 * 在以下实例中，pushAll的src参数产生的E实例给Stack使用，因此src的类型为Collection<? extends R>;popAll的dist参数通过Stack消费E实例，因此dist相应的类型为collection<? super E>。
 * @auther: Dimple
 * @date: 06/06/19
 * @version: 1.0
 */
public class Item31 {
    public static void main(String[] args) {
        Stack1<Number> numberStack = new Stack1<>();
        Iterable<Integer> integers = null;
        numberStack.pushAll(integers);
    }
}

class Stack1<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * this element array will contain only E instance form push(E).
     * this is sufficient to ensure type safety,but the runtime type of the array won't be E[];it will always be Object[]
     */
    @SuppressWarnings("unchecked")
    public Stack1() {
        /**
         * 消除泛型数组创建错误的第一种方法：直接绕过创建泛型数组的禁令
         * 创建一个Object数组，然后将它转为泛型类型数组
         */
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * notice
     *
     * @param src
     */
    //    public void pushAll(Iterable<E> src) {
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }


    public void popAll(Collection<? super E> dist) {
        while (!isEmpty()) {
            dist.add(pop());
        }
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * elements.length + 1);
        }
    }
}

