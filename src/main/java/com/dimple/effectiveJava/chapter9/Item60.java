package com.dimple.effectiveJava.chapter9;

/**
 * @className: Item60
 * @description: 如果需要精确地答案，避免使用float和double
 * float和double类型主要是为了科学计算和工程计算而设计的。float和double不适合货币计算。
 * 一般使用BigDecimal、int、long进行计算
 * 然而使用BigDecimal有两个缺点：与基本运算类型相比，这样做很不方便、而且速度很慢。
 * 如果数字范围没有操作9位十进制可以使用int、不超过18位可以使用long、超过18位就使用BigDecimal
 * @auther: Dimple
 * @date: 06/14/19
 * @version: 1.0
 */
public class Item60 {

    public static void main(String[] args) {
        System.out.println(1.03 - 0.42);//0.6100000000000001
        System.out.println(1.00 - 9 * 0.10);//0.09999999999999998
    }

}
