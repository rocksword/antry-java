package com.an.antry.java.multithread;

public class HelloThreadTest {
    public static void main(String[] args) {
        HelloThread r = new HelloThread();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}

class HelloThread implements Runnable {
    // If i is a member variable, HelloThread's instance r contains only one i, then all thread share the same
    // i variable, print 0 to 49
    int i;

    @Override
    public void run() {

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