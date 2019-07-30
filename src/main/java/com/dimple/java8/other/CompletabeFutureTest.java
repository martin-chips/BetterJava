package com.dimple.java8.other;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @className: CompletabeFutureTest
 * @description:
 * @auther: Dimple
 * @date: 07/17/19
 * @version: 1.0
 */
public class CompletabeFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("task doing");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "result";
        });
        future.get();
    }
}
