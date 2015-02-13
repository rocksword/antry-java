package com.an.antry.java.iv;

public class ClassSomeOtherClass {
    interface ExampleInterface {
        void interfaceMethod();
    }

    class ExampleClass {
        void exampleMethod(ExampleInterface e) {
        }
    }

    void start() {
        ExampleClass ex = new ExampleClass();
        ex.exampleMethod(new ExampleInterface() {
            @Override
            public void interfaceMethod() {
            }
        });
    }
}
