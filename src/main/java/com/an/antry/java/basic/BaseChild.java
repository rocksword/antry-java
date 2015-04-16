package com.an.antry.java.basic;

class Base {
    public void play1() {
        System.out.println("Base");
    }
}

public class BaseChild extends Base {
    // This static method cannot hide the instance method from Base
    // public static void play1() {
    // System.out.println("Child");
    // }

    public static void play2() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        BaseChild bc = new BaseChild();
        bc.play2();
    }
}
