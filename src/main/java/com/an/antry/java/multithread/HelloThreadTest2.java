package com.an.antry.java.multithread;

public class HelloThreadTest2 {
    public static void main(String[] args) {
        HelloThread2 r = new HelloThread2();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}

class HelloThread2 implements Runnable {
    @Override
    public void run() {
        int i = 0;
        // Every thread own its one local variable copy, they don't impact each other
        // So, print 100 numbers, 0 to 49 twice
        while (true) {
            System.out.println("Hello number: " + i++);
            try {
                Thread.sleep((long) Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (50 == i) {
                break;
            }
        }
    }
}