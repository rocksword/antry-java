package com.an.antry.java.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void test() {
        String s1 = "0";
        String s2 = "0.0";
        String s3 = "0.0,0";
        String s4 = "9.0,0";
        String s5 = "A";
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
        System.out.println(s2.compareTo(s3));
        System.out.println(s3.compareTo(s4));
        System.out.println(s4.compareTo(s5));
        System.out.println(s4.compareTo(s4));
        System.out.println(s5.compareTo(s1));
    }
}
