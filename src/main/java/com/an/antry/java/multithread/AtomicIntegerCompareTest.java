package com.an.antry.java.multithread;

import java.util.concurrent.atomic.AtomicInteger;

//http://blog.csdn.net/sunnydogzhou/article/details/6564396
public class AtomicIntegerCompareTest {
    public static void main(String args[]) {
        long start = System.currentTimeMillis();
        MyAtomicInteger test = new MyAtomicInteger(0);
        for (int i = 0; i < 100000000; i++) {
            test.increase();
        }
        long end = System.currentTimeMillis();
        System.out.println("time elapse:" + (end - start));

        long start1 = System.currentTimeMillis();
        AtomicInteger atomic = new AtomicInteger(0);
        for (int i = 0; i < 100000000; i++) {
            atomic.incrementAndGet();
        }
        long end1 = System.currentTimeMillis();
        System.out.println("time elapse:" + (end1 - start1));
    }
}

class MyAtomicInteger {
    private int value;

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public synchronized int increase() {
        return value++;
    }
}
