package com.an.antry.java.iv;

public class Outer {
    int instanceVar = 5;

    static class NestedStatic {
        public static void main(String[] args) {
            /*
             * instanceVar is a non-static variable belonging to the Outer class:
             */
            // instanceVar = 10;
            System.out.println(new Outer().instanceVar);
        }
    }
}
