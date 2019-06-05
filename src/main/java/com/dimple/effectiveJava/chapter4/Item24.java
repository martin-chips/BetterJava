package com.dimple.effectiveJava.chapter4;


/**
 * @className: Item24
 * @description: 静态成员类优于非静态成员类
 * 嵌套类（nested class）是定义在另一个类的内部的类。嵌套类存在的目的应该只是为了它的外围类（enclosing class）提供服务。如果嵌套类将来会引用到其他的某个环境中，就应该是顶层类（top-level class）。
 * 嵌套类有四种：
 * 1. 静态成员类 （static member class）
 * 2. 非静态成员类（nonstatic member class）
 * 3. 匿名类（anonymous class）
 * 4. 局部类（local class）
 * 除1外，其他的称为内部类(inner class);
 * <p>
 * 静态成员类是最简单的一种嵌套类，只是被声明在另一个类的内部而已。它可以访问外部类的所有成员，包括声明为私有的成员。静态成员类是外部类的一个静态成员，与其他静态成员一样，也遵守同样的可访问规则。如果类被声明为私有的，就只能在外围类的内部才可以被访问。
 * 静态成员类的一种常见用法是作为共有类的辅助类，只有与它的外部类一起使用才有意义。
 * 从语法上来看，静态成员类和非静态成员类之间的区别是：静态成员类的声明包含修饰符static。非静态成员类的每个实例都隐含的与外围类的一个外围实例相关联。在非静态成员类的实例方法内部，可以调用外围实例上的方法，或者利用修饰过的this构造获得外围实例的引用。
 * 如果嵌套类的实例可以在它外围类的实例之外独立存在，这个嵌套类就必须是静态成员类；
 * 非静态类的一种常用的用法是定义一个Adapter，它允许外部类的实例被看做另一个不相关的类的实例。
 * 如果生命成员类不要求外围实例访问，就要始终将static放在它的声明中，使它成为一个静态成员类，如果省略了static修饰符，则每个实例都将包含一个额外的指向外围对象的引用。保留这份引用需要消耗时间和空间，并且会导致外围实例在符合垃圾回收的时候仍然保留。
 * <p>
 * 匿名类是没有名字的，他不是一个外围类的成员。它并不与其他成员一起被声明，而是在使用的时候同时被声明和实例化。匿名类可以出现在代码中任何允许存在表达式的地方。但是即使他们出现在静态的环境中，也不可能拥有任何静态成员，而是拥有常数变量，常数变量是final基本类型，或者被初始化成擦脸表达式的字符串域。
 * 匿名类的运用收到诸多限制，除了在他们被声明的地方外，是无法将他们实例化。不能执行instanceof测试，或者任何需要命名类做的其他事。无法声明一个匿名类实现多个接口或者扩展一个类，并同时扩展类和实现接口。除了从父类继承得到的外，匿名类无法调用任何成员。
 * <p>
 * 局部类是四种嵌套类中使用最少的类。在任何可以声明局部变量的地方，都可以声明局部类，与成员类一样，局部类有名字，可以被重复使用。
 * @auther: Dimple
 * @date: 05/31/19
 * @version: 1.0
 */
public class Item24 {
}

/**
 * 静态成员类
 */
class StaticMemberClassTest {
    private static String name = "Dimple";
    private int id = 11;
    public static int num = 200;

    static class Person {
        public String address = "address";
        private String detail = "no detail";
        private static String detailStatic = "no detail";

        public void display() {
            System.out.println(name);
            //System.out.println(id); 不能访问外部类的非静态成员    【静态方法不能直接访问非静态成员】
            System.out.println(num);
        }
    }

    public void print() {
        Person person = new Person();
        person.display();
        System.out.println(person.detail);
        System.out.println(person.address);
        System.out.println(Person.detailStatic);
    }

    public static void main(String[] args) {
        StaticMemberClassTest staticMemberClassTest = new StaticMemberClassTest();
        staticMemberClassTest.print();
    }
}

/**
 * 内部类
 */
class OuterClass {
    private int out_x = 100;

    /**
     * 内部类加不加访问修饰符无影响
     * 内部类中可以直接访问外部类的数据成员和方法。
     */
    class InnerClass {
        public int y = 10;
        private int z = 20;
        int m = 5;

        public void display() {
            System.out.println(out_x);
        }
    }

    void test() {
        InnerClass innerClass = new InnerClass();
        innerClass.display();
        System.out.println(innerClass.m);
        System.out.println(innerClass.y);
        System.out.println(innerClass.z);
    }
}

/**
 * 匿名类_继承式匿名类
 */
class Car {
    public void drive() {
        System.out.println("test");
    }
}

class Test {
    public static void main(String[] args) {
        Car car = new Car() {
            @Override
            public void drive() {
                super.drive();
            }
        };
    }
}

/**
 * 接口式匿名类
 */
interface Vehicle {
    public void drive();
}

class VehicleTest {
    Vehicle vehicle = new Vehicle() {
        @Override
        public void drive() {

        }
    };
}

/**
 * 参数式匿名类
 */

class Bar {
    void doBar(Foo f) {
        System.out.println();
    }
}

interface Foo {
    void foo();
}

class BarTest {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.doBar(new Foo() {
            @Override
            public void foo() {

            }
        });
    }
}

