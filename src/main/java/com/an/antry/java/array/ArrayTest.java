package com.an.antry.java.array;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.test();
    }

    public void test() {
        String[] arr = new String[] { "f", "a", "3", "c", "4" };
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
    }
}
