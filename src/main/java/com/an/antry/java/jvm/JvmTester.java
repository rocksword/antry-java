package com.an.antry.java.jvm;

public class JvmTester {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
    }
}