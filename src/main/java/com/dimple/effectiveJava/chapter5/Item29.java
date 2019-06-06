package com.dimple.effectiveJava.chapter5;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @className: Item29
 * @description: 优先考虑泛型
 * 以下两种消除泛型数组创建的方法，各有所长。
 * 第一种方法可读性更强：数组被申明为E[]类型表名它只包含E的实例。它也更加简洁：在创建一个典型的泛型类中，可以在代码中的多个位置读取到该数组，第一种方法只转换一次（在创建数组的时候），而第二种方法则是每次读取一个数组元素的时候都需要转换一次。但是可能导致堆污染。
 * <p>
 * 实际上不可能总在泛型中使用列表，Java并不是生来就支持列表，因此有些泛型比如ArrayList必须要在数组上实现。
 * 绝大数的泛型对类型参数没有限制，但是不能创建基本类型的泛型参数。
 * <p>
 * 有一些泛型限制了可允许的类型参数值，以DelayQueue为例：public class DelayQueue<E extends Delayed> extends AbstractQueue<E>，参数E必须是Delayed的一个子类。这种参数E成为有限制的参数类型。
 * @auther: Dimple
 * @date: 06/06/19
 * @version: 1.0
 */
public class Item29 {
}

/**
 * 这个类应该先被参数化，但是没有，在后面可以将它泛型化。
 */
class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
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

/**
 * 将类泛型化的第一步就是在申明中添加一个或者多个类型参数
 *
 * @param <E>
 */
class StackGenerify<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * this element array will contain only E instance form push(E).
     * this is sufficient to ensure type safety,but the runtime type of the array won't be E[];it will always be Object[]
     */
    @SuppressWarnings("unchecked")
    public StackGenerify() {
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


class StackGenerify2<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackGenerify2() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        /**
         * 由于E是一个不可具体化的类型，编译器无法在运行时检验转换。
         */
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
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