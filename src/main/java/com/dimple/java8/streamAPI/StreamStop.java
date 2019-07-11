package com.dimple.java8.streamAPI;

import com.dimple.java8.streamAPI.common.Employee;
import com.dimple.java8.streamAPI.common.EmployeeData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @className: StreamStop
 * @description: Stream终止操作
 * @auther: Dimple
 * @date: 07/11/19
 * @version: 1.0
 */
public class StreamStop {

    static List<Employee> employees = EmployeeData.getEmployee();


    //allMatch=判断是否匹配所有元素，判断所有都是true
    public static void stopAllMatch() {
        boolean b = employees.stream().allMatch(e -> e.getId() <= 100);
        System.out.println(b);
    }

    //检查是否至少匹配所有元素,判断是否有一个是true
    public static void stopAnyMatch() {
        boolean b = employees.stream().anyMatch(e -> e.getId() < 3);
        System.out.println(b);
    }

    //检查是否没有匹配的元素，判断是否没有true
    public static void stopNoneMatch() {
        boolean b = employees.stream().noneMatch(e -> e.getId() <= 100);
        System.out.println(b);
    }

    //findFirst-返回第一个元素
    public static void stopFindFirst() {
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
        //findFirst返回值为Optional，将Employee封装了一层，防止返回空指针。
        //orElse的意思是如果返回为空就用这个参数替代
        first.orElse(new Employee(1, "Dimple"));
    }

    //返回当前流中的任意元素
    public static void stopFindAny() {
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);
        any.orElse(new Employee(1, "Dimple"));
    }

    //count-返回当前流中的数量
    public static void stopCount() {
        long count = employees.stream().count();
        System.out.println(count);
    }

    //max-返回流中最大值
    public static void stopMax() {
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getMoney));
        System.out.println(max);
    }

    //min-返回流中的最小值
    public static void stopMin() {
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getMoney));
        System.out.println(min);
    }

    /**
     * 归约：将流中元素反复结合在一起，得到一个值
     */
    //reduce(T identity,BinaryOperator ),传入一个起始值，然后传入一个二元运算
    public static void stopReduce() {
        List<Integer> integers = Arrays.asList(1, 2);
        Integer reduce = integers.stream().reduce(6, (x, y) -> x + y);
        System.out.println(reduce);
    }

    //reduce(BinaryOperator) ，传入一个二元运算
    public static void stopReduce2() {
        List<Integer> integers = Arrays.asList(1, 2);
        Optional<Integer> reduce = integers.stream().reduce(Integer::sum);
        reduce.orElse(-1);
        System.out.println(reduce.get());
    }

    /**
     * 收集collect（将流转换为其他形式，接收一个Collector接口的实现，用于给其他Stream中元素做汇总的方法）
     * Collect接口中方法的实现决定了如何对流执行收集操作（如收集到List、Set、Map）。但是Collectors工具类提供了很多静态方法，可以用于创建收集器实例。
     */
    //collectors.toList 将流转为list
    public static void stopCollectToList() {
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
    }

    //collectors.toSet 将流转为Set
    public static void stopCollectToSet() {
        Set<Integer> collect = employees.stream().map(Employee::getId).collect(Collectors.toSet());
        System.out.println(collect);
    }

    //Collectors.toCollection 将流转为其他类型的集合
    public static void stopToCollection() {
        LinkedList<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(collect);
    }

    //Collectors.counting() 元素个数
    public static void stopCounting() {
        Long collect = employees.stream().collect(Collectors.counting());
        System.out.println(collect);
    }

    //Collections.averagingDouble/Long/Int 求平均，传入参数不同，三个方法
    public static void stopAverage() {
        Double collect = employees.stream().map(Employee::getMoney).collect(Collectors.averagingDouble(x -> x));
        System.out.println(collect);
    }

    //Collections.maxBy 求最大值
    public static void stopMaxBy() {
        Optional<Integer> max = employees.stream().map(Employee::getId).max(Integer::compare);
        System.out.println(max.get());
    }

    //Collections.minBy 求最大值
    public static void stopMinBy() {
        Optional<Integer> min = employees.stream().map(Employee::getId).min(Integer::compare);
        System.out.println(min.get());
    }

    //Collectors.groupBy分组，返回一个map
    public static void stopGroupBy() {
        Map<Double, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getMoney));
    }

    //Collectors.partitioningBy()分区，参数传入一个参数，返回true和false分成两个区域
    public static void stopPartitioningBy() {
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(x -> x.getId() < 5));
        System.out.println();
    }

    public static void main(String[] args) {
        stopAllMatch();
        System.out.println("**********");
        stopAnyMatch();
        System.out.println("**********");
        stopAnyMatch();
        System.out.println("**********");
        stopFindFirst();
        System.out.println("**********");
        stopReduce();
        System.out.println("**********");
        stopReduce2();
        System.out.println("**********");
        stopCollectToList();
        System.out.println("**********");
        stopCollectToSet();
        System.out.println("**********");
        stopToCollection();
        System.out.println("**********");
        stopCounting();
        System.out.println("**********");
        stopAverage();
        System.out.println("**********");
        stopMaxBy();
        System.out.println("**********");
        stopMinBy();
        System.out.println("**********");
        stopPartitioningBy();
        System.out.println("**********");
    }
}
