package com.an.antry.java.iv;

class OuterClass2 {
    private int privInt = 10;

    public static void main(String[] args) {
        OuterClass2 inst = new OuterClass2();
        inst.createInnerClass();
    }

    public void createInnerClass() {
        InnerClass inClass = new InnerClass();
        inClass.accessOuter();
    }

    class InnerClass {
        public void accessOuter() {
            System.out.println("The outer class's privInt is " + privInt);
        }
    }
}