package com.dimple.effectiveJava.chapter2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @className: Item9
 * @description: try-with-resources优于try finally
 * Java类库中包括许多需要调用close方法来手工关闭的资源，如InputStream、OutputStream等，如果忘记关闭会对性能造成影响，虽然有终结方法，但效果并不理想。
 * 在Java7引入try -with -resources语句。要使用这个构造的资源，需要实现AutoCloseable接口，其中包含了返回值为void的close方法。Java许多类库中已经扩展了autoclose接口。
 * 如果编写一个类，代表的是需要被关闭的资源，那么这个类也应该实现AutoCloseable接口.
 * 使用try-with-resources不仅可以使得代码变得整洁，还容易诊断，如果调用readLine发生异常，那么后一个异常就会被禁止，以保留第一个异常，被禁止的异常并未被抛弃，依然会被
 * 打印在堆栈信息中，并标明他们是被禁止的异常，通过编程调用GetSuppressed方法可以访问他们。
 * 在try-with-resources中还可以使用catch语句。
 * @auther: Dimple
 * @date: 05/23/19
 * @version: 1.0
 */
public class Item9 {
    // no longer the bast way to close resources

    /**
     * 如果在底层硬件发生异常，那么在调用ReadLine的时候就会抛出异常，同样，close方法也会抛出异常，但是在这种情况下，第二个异常会抹除第一个异常
     * 在异常堆栈中就没有第一个异常的记录，这样会使得调试变得复杂。
     */
    public static String firstLineOfFile1(String path) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    //try finally id ugly when used with more than one resource

    /**
     * 在以上的方法中，try和finally中都有可能会抛出异常。
     */
    public static void copy(String src, String dst) throws Exception {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] bytes = new byte[1024];
                int n;
                while ((n = in.read(bytes)) >= 0) {
                    out.write(bytes, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static String methodWithTryWithResources(String path) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.readLine();
        }
    }

    public static void copyTryWith(String src, String dst) throws Exception {
        try (InputStream inputStream = new FileInputStream(src);
             OutputStream outputStream = new FileOutputStream(dst)
        ) {
            byte[] bytes = new byte[1024];
            int n;
            while ((n = inputStream.read(bytes)) >= 0) {
                outputStream.write(bytes, 0, n);
            }
        }
    }
}
