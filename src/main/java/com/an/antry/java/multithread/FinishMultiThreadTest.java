package com.an.antry.java.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinishMultiThreadTest {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        long t1 = System.currentTimeMillis();

        List<Thread1> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread1 myThread = new Thread1(i);
            myThread.start();
            list.add(myThread);
        }

        for (Thread1 myThread : list) {
            try {
                myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Finished running all threads, time: " + (t2 - t1));
    }
}

class Thread1 extends Thread {
    private int i;

    public Thread1(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        int time = Math.abs(new Random().nextInt(10));
        System.out.println(String.format("Start thread: %s, time: %s", i, time));
        try {
            sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished running thread: " + i);
    }
}
