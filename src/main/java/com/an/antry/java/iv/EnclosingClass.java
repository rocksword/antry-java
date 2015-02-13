package com.an.antry.java.iv;

public class EnclosingClass {
    public static void main(String[] args) {
        // access enclosed class:
        Nested n = new Nested();
        n.anotherMethod(); // prints out "hi again"
    }

    static class Nested {
        void someMethod() {
            System.out.println("someMethod,hello in Nested.");
        }

        void anotherMethod() {
            System.out.println("anotherMethod, hello in Nested.");
        }
    }
}
