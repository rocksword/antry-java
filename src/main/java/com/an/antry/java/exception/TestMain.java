package com.an.antry.java.exception;

public class TestMain {
    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        try {
            System.out.println("Before return;");
            return 11;
        } catch (Exception e) {
            return 88;
        } finally {
            System.out.println("In finally.");
            return 99;
        }
    }
}
