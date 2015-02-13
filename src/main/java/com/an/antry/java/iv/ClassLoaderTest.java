package com.an.antry.java.iv;

public class ClassLoaderTest {
    public static void main(String[] args) {
        String classpath = System.getProperty("java.class.path");
        String[] strs = classpath.split(";");
        System.out.println("java.class.path: ");
        int i = 0;
        for (String str : strs) {
            System.out.println(i++ + ": " + str);
        }
    }
}
