package com.an.antry.java.jvm;

public class LoopTest {
    public LoopTest() {
        super();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        spendTime();
        long end = System.nanoTime();
        System.out.println("Time spent: " + (end - start));
        LoopTest loopTest = new LoopTest();
    }

    private static void spendTime() {
        for (int i = 500000000; i > 0; i--) {
        }
    }
}
