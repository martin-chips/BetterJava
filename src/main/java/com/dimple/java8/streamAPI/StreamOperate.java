package com.dimple.java8.streamAPI;

import com.dimple.java8.streamAPI.common.Employee;
import com.dimple.java8.streamAPI.common.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @className: StreamOperate
 * @description: Stream的中间操作
 * @auther: Dimple
 * @date: 2019/7/10
 * @version: 1.0
 */
public class StreamOperate {

    private static List<Employee> employees = EmployeeData.getEmployee();

    public static void main(String[] args) {
        operateFilter();
        System.out.println("**********");
        operateLimit();
        System.out.println("**********");
        operateSkip();
        System.out.println("**********");
        operateDistinct();
        System.out.println("**********");
        operateMap();
        System.out.println("**********");
        operateFlatMap();
        System.out.println("**********");
        operateSort();
        System.out.println("**********");

    }

    //一、筛选与切片
    //Filter 接收Lambda表达式，从流中排除某些元素
    public static void operateFilter() {
        employees.stream().filter(e -> e.getMoney() < 10).forEach(System.out::println);
    }

    //Limit-截断流，使元素不超过给定数量
    public static void operateLimit() {
        employees.stream().limit(2).forEach(System.out::println);
        //只有有两条满足条件的记录，就不会往下计算
        employees.stream().filter(e -> e.getId() < 3).limit(2).forEach(System.out::println);
    }

    //Skip-跳过元素，Skip(n)表示返回一个扔掉前n个元素的流，如流中元素不足n个，就返回一个空
    public static void operateSkip() {
        employees.stream().skip(100).forEach(System.out::println);
    }

    //distinct-去重，利用实体类中的hashCode和equals方法去除重复元素
    public static void operateDistinct() {
        employees.stream().distinct().forEach(System.out::println);
    }

    //map-映射，将元素转换为其他形式或者提取信息，接收一个函数做为参数，还函数会被应用到每个元素上，并将其映射层一个新的元素
    public static void operateMap() {
        Stream<String> stream = Arrays.asList("aa", "bb", "cc", "dd").stream();
        stream.map(e -> e.toUpperCase()).forEach(System.out::println);
    }

    //flatMap-接收一个函数作为参数，将流中的每一个值都转换成一个流，然后把所有流连接成一个流
    public static void operateFlatMap() {
        Stream<String> stringStream = Arrays.asList("aa", "bb", "cc", "dd").stream();
        stringStream.flatMap(e -> filterCharacter(e)).forEach(System.out::println);

    }

    /**
     * 将一个字符串转换为流
     *
     * @param string
     * @return
     */
    private static Stream<Character> filterCharacter(String string) {
        List<Character> list = new ArrayList<>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //sort -排序：sorted有两种方法，一种是不传任何参数，叫自然排序，一种是传Comparator接口参数，叫做定制排序
    public static void operateSort() {
        //自然排序
        List<Employee> collect = employees.stream().sorted().collect(Collectors.toList());
        System.out.println(collect.toString());
        //定制排序
        List<Employee> collect1 = employees.stream().sorted((o1, o2) -> {
            if (o1.getId() > o2.getId()) {
                return 1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());
        System.out.println(collect1.toString());
    }
}
