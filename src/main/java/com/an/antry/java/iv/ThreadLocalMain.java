package com.an.antry.java.iv;

public class ThreadLocalMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Runnable() {
                @Override
                public void run() {
                    System.out.println(ThreadId.get());
                }
            }.run();
        }
    }

}
