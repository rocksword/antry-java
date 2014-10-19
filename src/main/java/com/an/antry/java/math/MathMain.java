package com.an.antry.java.math;

public class MathMain {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        // Compute 7 + 6 + 5 + 4 + 3 + 2 + 1
        int cnt = 7;
        int total = 0;
        for (int i = 1; i < cnt; i++) {
            total += i;
        }
        System.out.println(total);
    }
}
