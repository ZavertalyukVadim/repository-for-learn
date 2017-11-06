package com.example.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DemoApplication {

    public static void main(String[] args) {
        //метод возвращает 10 (вывод в консоль). внутри метода  слип на 2 секунды. вызвать три раза, просумировать результаты. работа 2 секунды.
        //экзекютор и коллебл
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future<Integer> submit = executorService.submit(new MyCallable());
        Future<Integer> submit1 = executorService.submit(new MyCallable());
        Future<Integer> submit2 = executorService.submit(new MyCallable());
        Integer sum = null;
        try {
            System.out.println("first thread " + submit.get());
            System.out.println("second thread " + submit1.get());
            System.out.println("third thread " + submit2.get());
            sum = submit.get() + submit1.get() + submit2.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Sum = " + sum);
        executorService.shutdown();
    }
}
