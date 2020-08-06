package com.lss.code.juc01;

public class ExtendsThread extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }
}