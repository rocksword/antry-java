package com.an.antry.java.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public static void main(String[] args) {
        TestSemaphore test = new TestSemaphore();
        test.run();
    }

    private void run() {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            MyRunnable run = new MyRunnable(index, semp);
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}

class MyRunnable implements Runnable {
    private Semaphore semp;
    private int num;

    public MyRunnable(int num, Semaphore semp) {
        this.semp = semp;
        this.num = num;
    }

    public void run() {
        try {
            // 获取许可
            semp.acquire();
            System.out.println("Accessing thread: " + num);
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("Available permits count: ------- " + semp.availablePermits());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 访问完后，释放
            semp.release();
        }
    }
};