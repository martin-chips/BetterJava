package com.dimple.effectiveJava.chapter6.myInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: ExceptionTest
 * @description:
 * @auther: Dimple
 * @date: 07/15/19
 * @version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Exception> value();
}
