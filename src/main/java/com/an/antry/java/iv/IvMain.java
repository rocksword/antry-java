package com.an.antry.java.iv;

import java.util.ArrayList;
import java.util.List;

public class IvMain {
    public static void main(String[] args) {
        System.out.println(sumFromOneToN(2, 0));
        test();
        System.out.println("CPU: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Integer max: " + Integer.MAX_VALUE);// 32 bit
        System.out.println("Integer min: " + Integer.MIN_VALUE);// 32 bit
        System.out.println("Long max: " + Long.MAX_VALUE);// 64 bit
        System.out.println("Long min: " + Long.MIN_VALUE);// 64 bit
        int val = Integer.MAX_VALUE;
        long big = val + 1;
        long big2 = (long) val + 1L;
        System.out.println("big: " + big + ", big2: " + big2);

        absoluteOfMostNegativeValue();

        List<String> list1 = new ArrayList<>();
        list1.add("String 1");
        System.out.println("list1 size: " + list1.size());
        List<String> list2 = list1;
        list2.add("String 2");
        System.out.println("list1 size: " + list1.size());
    }

    public static void absoluteOfMostNegativeValue() {
        final int mostNegative = Integer.MIN_VALUE;
        final int negated = Math.abs(mostNegative);
        System.out.println("negated: " + negated);
        if (negated < 0) {
            System.out.println("No positive equivalent of Integer.MIN_VALUE");
        }
    }

    public static int sumFromOneToN(int n, int a) {
        if (n < 1) {
            return a;
        }
        return sumFromOneToN(n - 1, a + n);
    }

    static void test() {
        String A1 = "A";
        String A2 = "A";
        checkInstance(A1, A2);

        String B1 = new String("A");
        String B2 = new String("A");
        checkInstance(B1, B2);

        checkInstance(A1, "A");
        checkInstance(A2, "A");
        checkInstance(B1, "A");
        checkInstance(B2, "A");
    }

    static void checkInstance(String a1, String a2) {
        if (a1 == a2) {
            System.out.println("Same instance");
        } else {
            System.out.println("Different instance");
        }
    }
}
