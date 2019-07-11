package com.dimple.java8.lambdaAndRef;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @className: ConstructorReferences
 * @description: 构造器引用
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致.抽象方法的返回值类型即为所属的类的类型
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class ConstructorReferences {

    public static void main(String[] args) {
        ConstructorRef1();
        ConstructorRef2();
        ConstructorRef3();
    }

    /**
     * 构造器引用
     * Supplier中的T get()
     * Employee中的空构造器
     */
    public static void ConstructorRef1() {
        Supplier<Employee> employeeSupplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };

        Supplier<Employee> employeeSupplierConstructor = () -> new Employee();
        System.out.println(employeeSupplier.get());

        Supplier<Employee> employeeSupplierConstructorRef = Employee::new;
        System.out.println(employeeSupplierConstructorRef.get());
    }

    /**
     * Function 中的R apply(T t)
     * 构造器中的Employee(Integer id)
     */
    public static void ConstructorRef2() {
        Function<Integer, Employee> function = new Function<Integer, Employee>() {
            @Override
            public Employee apply(Integer integer) {
                return new Employee(integer);
            }
        };

        Function<Integer, Employee> function1Lambda = (id) -> new Employee(id);
        System.out.println(function1Lambda.apply(100));

        Function<Integer, Employee> functionConstructorRef = Employee::new;
        System.out.println(functionConstructorRef.apply(101));
    }

    /**
     * BiFunction中的R apply(T t,U u)
     * Employee中的两个参数的构造器
     */
    public static void ConstructorRef3() {
        BiFunction<Integer, String, Employee> biFunction = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer integer, String s) {
                return new Employee(integer, s);
            }
        };

        BiFunction<Integer, String, Employee> biFunctionLambda = (id, name) -> new Employee(id, name);
        System.out.println(biFunction.apply(1, "Dimple"));

        BiFunction<Integer, String, Employee> biFunctionConstructorRef = Employee::new;
        System.out.println(biFunctionConstructorRef.apply(1, "Dimple"));
    }
}

class Employee {
    Integer id;
    String name;
    Double money;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}