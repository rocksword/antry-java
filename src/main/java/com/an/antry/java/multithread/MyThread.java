package com.an.antry.java.multithread;

import java.util.Random;

public class MyThread extends Thread {
    private int i;

    public MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        Random random = new Random();
        int time = random.nextInt(10);
        if (time < 0) {
            time = time + 10;
        }
        System.out.println(String.format("Start thread: %s, time: %s", i, time));
        try {
            sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished running thread: " + i);
    }
}
