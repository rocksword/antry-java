package com.an.antry.java.iv;

public class NonEnclosingClass {
    public static void main(String[] args) {
        /*
         * instantiate the Nested class that is a static member of the EnclosingClass class:
         */
        EnclosingClass.Nested n = new EnclosingClass.Nested();
        n.someMethod(); // prints out "hello"
    }
}
