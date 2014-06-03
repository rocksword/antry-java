package com.an.antry.java.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueMain {
    private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    private int threadCount = 10;
    // CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
    private CountDownLatch latch = new CountDownLatch(threadCount);

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueueMain main = new ConcurrentLinkedQueueMain();
        main.execute();
    }

    private void execute() throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(4);
        offer();
        System.out.println("queue size: " + queue.size());
        for (int i = 0; i < threadCount; i++) {
            es.submit(new Poll("Poll_" + i));
        }
        latch.await();
        // 使得主线程(main)阻塞直到latch.countDown()为零才继续执行
        System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
        es.shutdown();
    }

    public void offer() {
        for (int i = 0; i < 100000; i++) {
            queue.offer(i);
        }
    }

    class Poll implements Runnable {
        private String name;

        public Poll(String name) {
            this.name = name;
        }

        public void run() {
            while (!queue.isEmpty()) {
                System.out.println(name + " poll: " + queue.poll());
            }
            latch.countDown();
        }
    }
}
