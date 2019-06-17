package com.dimple.effectiveJava.chapter10;

/**
 * @className: Item74
 * @description: 每个方法抛出的所有异常都要建立文档
 * 始终要单独的声明受检异常，并且利用Javadoc的@throws标签,准确记录下抛出异常的每一个条件。如果一个公有方法可能抛出多个异常类，不能抛出这个异常类的父类。
 * 使用javadoc的@throws标签记录下一个方法可能抛出的每一个未受检异常，但不要使用throw关键字将未受检异常包含在方法的声明中。
 *
 * 总而言之，为编写的每一个方法所能抛出的异常建立文档。对于未受检异常和受检异常，以及抽象的方法和具体的方法一概如此。这个文档在文档注释中应该采用@throws标签的形式。
 * 要在方法的throws子句中为每个受检异常提供单独的声明，但是不要声明未受检异常。
 * @auther: Dimple
 * @date: 06/17/19
 * @version: 1.0
 */
public class Item74 {
}
