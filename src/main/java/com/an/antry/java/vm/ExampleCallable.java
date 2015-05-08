package com.an.antry.java.vm;

import java.util.concurrent.Callable;

public class ExampleCallable implements Callable<Double> {
    private int a;

    public ExampleCallable(int b) {
        this.a = b;
    }

    @Override
    public Double call() throws Exception {
        return 3.1415;
    }
}
