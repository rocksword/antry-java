package com.an.antry.java.multithread;

import java.util.ArrayList;
import java.util.List;

public class FinishMultiThreadTest {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        long t1 = System.currentTimeMillis();

        List<MyThread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread(i);
            myThread.start();
            list.add(myThread);
        }

        for (MyThread myThread : list) {
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
