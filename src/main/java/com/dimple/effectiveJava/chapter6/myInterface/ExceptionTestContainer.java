package com.dimple.effectiveJava.chapter6.myInterface;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: ExceptionTestContainer
 * @description:
 * @auther: Dimple
 * @date: 07/15/19
 * @version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionTestContainer {
    ExceptionTest[] value();
}
