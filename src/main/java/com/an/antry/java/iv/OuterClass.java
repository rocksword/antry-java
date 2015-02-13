package com.an.antry.java.iv;

public class OuterClass {
    public static void main(String[] args) {
        System.out.println("Outer class.");
    }

    static class InnerClass {
        public static void main(String[] args) {
            System.out.println("Inner class.");
        }
    }
}
