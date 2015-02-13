package com.an.antry.java.iv;

public class OutClass3 {
    public static void main(String[] args) {
        OuterClass2 inst = new OuterClass2();
        inst.createInnerClass();

        OuterClass2.InnerClass inner = new OuterClass2().new InnerClass();
        inner.accessOuter();
    }
}
