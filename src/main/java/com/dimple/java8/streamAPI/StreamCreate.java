package com.dimple.java8.streamAPI;

import com.dimple.java8.streamAPI.common.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @className: StreamAPI
 * @description: Stream API
 * Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，和内存打交道
 * <p>
 * Stream自己不存储元素；
 * Stream不改变源对象，相反，他们会返回一个持有结果的新Stream
 * Stream的操作是延迟执行的，则意味着只有等到结果的时候才会执行
 * <p>
 * Stream 执行流程：Stream的实例化--> 一系列的中间操作（过滤、映射）-->终止操作(只有执行终止操作的时候，才会立即执行中间操作)
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class StreamCreate {

    //创建Stream的方式:通过集合
    public static void createStreamByCollection() {
        List<Employee> employees = new ArrayList<>();
        //返回一个顺序流（Collections 的默认方法）
        Stream<Employee> stream = employees.stream();
        //返回一个并行流(Collections 的默认方法)
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建Stream的方式：通过数组(Arrays静态类中提供了一个静态的方法)

    /**
     * Arrays.stream（）有多种重载类型
     * IntStream stream()
     * LongStream stream()
     * Double stream()
     */
    public static void createStreamByArray() {
        int array[] = new int[]{1, 2, 3, 4, 5, 6};
        //创建int类型的Stream
        IntStream intStream = Arrays.stream(array);

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee[] employees = new Employee[]{employee1, employee2};
        Stream<Employee> stream = Arrays.stream(employees);
    }

    //创建Stream的第三种方法:通过Stream的of方法
    public static void createStreamByOf() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
    }
}

