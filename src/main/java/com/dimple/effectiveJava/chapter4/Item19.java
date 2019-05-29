package com.dimple.effectiveJava.chapter4;

import java.time.Instant;

/**
 * @className: Item19
 * @description: 要么设计继承并提供文档说明，要么禁止继承
 * 对于专门用于继承的设计的类需要良好的文档说明：
 * 1. 该类的文档必须精确的描述覆盖每个方法带来的影响。在文档的末尾，应该写上关于这些调用的描述信息：“implementation  Requirement”，由Javadoc的标签@ImplSpec生成。
 * <p>
 * <p>
 * 通过构造器调用私有的方法、final方法和静态方法是安全的，这些都不是可以被覆盖的方法。
 * 如果为了继承而设计的类中实现了Cloneable或者Serializable接口，就应该明白，因为clone和readObject方法在行为上类似于构造器，所以类似的限制规则也是适用的：
 * 【无论是clone还是readObject方法都不可以调用可覆盖的方法，不管是直接还是间接】
 * 对于readObject方法，覆盖的方法在子类的状态被反序列化之前先被运行；对于clone方法，覆盖的方法则是在子类的clone方法有机会修正被克隆的状态之前先被运行。
 * 如果设计为继承的类实现了SERIALIZABLE接口，并且该类有一个readResolve或者writeReplace方法，就需要使得其成为受保护的方法，而不是私有的方法。
 * @auther: Dimple
 * @date: 05/28/19
 * @version: 1.0
 */
public class Item19 {
}

class Super {
    public Super() {
        overrideMe();
    }

    public void overrideMe() {

    }
}

final class Sub extends Super {
    private final Instant instant;

    Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    /**
     * 之所以会出现这个结果是因为overrideMe方法被Sup调用的是否有，构造器Sub还没有初始化instance域。
     *
     * @param args
     */
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
        //result :
        // null
        //time
    }
}