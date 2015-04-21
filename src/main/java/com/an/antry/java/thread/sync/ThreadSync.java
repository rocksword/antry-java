package com.an.antry.java.thread.sync;

import java.util.Random;

public class ThreadSync {
    public static void main(String[] args) {
        Example example = new Example();
        new Thread1(example).start();
        new Thread2(example).start();
    }
}

class Example {
    private Object object = new Object();

    public void execute1() {
        System.out.println("execute1");
        synchronized (object) {
            for (int i = 0; i < 10; ++i) {
                try {
                    int s = Math.abs(new Random().nextInt(1000));
                    Thread.sleep(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " Hello: " + i);
            }
        }
    }

    public void execute2() {
        System.out.println("execute2");
        synchronized (object) {
            for (int i = 0; i < 10; ++i) {
                try {
                    int s = Math.abs(new Random().nextInt(1000));
                    Thread.sleep(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " World: " + i);
            }
        }
    }
}

class Thread1 extends Thread {
    private Example example;

    public Thread1(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.execute1();
    }
}

class Thread2 extends Thread {
    private Example example;

    public Thread2(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.execute2();
    }
}
