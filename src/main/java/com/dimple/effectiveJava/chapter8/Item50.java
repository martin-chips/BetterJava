package com.dimple.effectiveJava.chapter8;

import java.util.Date;

/**
 * @className: Item50
 * @description: 必要时进行保护性拷贝
 * 如果没有对象的帮助，另一个类不可能修改对象内部状态，但是对象很容易在无意识的情况下提供这种帮助。
 * 参数的保护性拷贝并不仅仅针对不可变类。每当编写方法或者构造器的时候，如果它允许客户提供的对象进入到内部数据结构中，则有必要考虑下，客户提供的对象是否可能是可变的。如果是，那么就需要考虑类是否允许进入数据结构
 * 之后发生的变化，如果不是，就应该进行保护性拷贝。并且让拷贝的数据而不是原始数据进入到对象中。
 * @auther: Dimple
 * @date: 06/11/19
 * @version: 1.0
 */
public class Item50 {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        end.setYear(1);//可以在此处修改时间，破坏了start<end 的条件

        period.getEnd().setYear(1);//此处也可以修改时间，破坏了start<end的条件
    }

}

final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        /*
        为了防止在创建对象后还可以更改对象内部的变量，应该使用保护性拷贝。同时应该先进行保护性拷贝，再进行参数验证，防止在验证通过后，另一个线程更改了时间。
        this.start = start;
        this.end = end;
        */
        //添加约束，开始时间不能大于结束时间，然而因为Date类本身是可以变的，所以很容易违反这个条件
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "after " + end);
        }
    }

    /**
     * 虽然在构造器上进行了验证，但是Period中还提供了对其可变内部成员的访问能力。
     */
    public Date getStart() {
//        return start;
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return end;
    }
}
