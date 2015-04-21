package com.an.antry.java.thread;

public class ThreadSync {
    public static void main(String[] args) {
        Example example = new Example();
        new Thread1(example).start();
        new Thread1(example).start();
    }
}

class Example {
    // public void execute() {
    public synchronized void execute() {
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello: " + i);
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
        example.execute();
    }
}