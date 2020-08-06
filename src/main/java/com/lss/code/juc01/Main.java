package com.lss.code.juc01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        //创建线程池
        ExecutorService service=Executors.newFixedThreadPool(1);
//提交任务，并用 Future提交返回结果
        Future<Integer> future=service.submit(new CallableTask());
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());

        future.cancel(true);
        System.out.println(future.get());

    }
}
