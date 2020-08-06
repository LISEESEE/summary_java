package com.lss.code.juc01;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("用实现Runnable接口实现线程");
    }
}