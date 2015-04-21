package com.an.antry.java.thread.ssync;

import java.util.Random;

public class ThreadSync {
    public static void main(String[] args) {
        Example example = new Example();
        new Thread1(example).start();
        new Thread2(example).start();
    }
}

class Example {
    public synchronized static void execute1() {
        for (int i = 0; i < 10; ++i) {
            try {
                int s = Math.abs(new Random().nextInt(1000));
                Thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello: " + i);
        }
    }

    public synchronized static void execute2() {
        for (int i = 0; i < 10; ++i) {
            try {
                int s = Math.abs(new Random().nextInt(1000));
                Thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("World: " + i);
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
        Example.execute1();
    }
}

class Thread2 extends Thread {
    private Example example;

    public Thread2(Example example) {
        this.example = example;
    }

    @Override
    public void run() {
        Example.execute2();
    }
}
