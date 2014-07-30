package com.an.antry.java.string;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void test() {
        String[] arr = new String[] { "f", "a", "3", "c", "4" };
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
    }
}
