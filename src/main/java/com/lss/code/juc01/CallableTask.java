package com.lss.code.juc01;

import java.util.Random;
import java.util.concurrent.Callable;

class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
