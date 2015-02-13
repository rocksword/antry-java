package com.an.antry.java.jpie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ObjectTest {
    public static void main(String[] args) {
        Test t1 = new Test(1, 11);
        Test t2 = new Test(1, 11);
        System.out.println(t1.hashCode() + ", t1: " + t1);
        System.out.println(t2.hashCode() + ", t2: " + t2);
        System.out.println("t1.equals(t2) " + t1.equals(t2));
        Set<Test> s = new HashSet<>();
        boolean ret = s.add(t1);
        System.out.println("Add t1, Ret: " + ret);
        boolean ret2 = s.add(t2);
        System.out.println("Add t2, Ret2: " + ret2);
        System.out.println(s.size());
        if (s.contains(t2)) {
            System.out.println("Exists!");
        } else {
            System.out.println("Not exists!");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("key", new int[] { 1, 2, 3, 4 });
        Object o = map.get("key");
        if (o instanceof int[]) {
            System.out.println("Array is object!");
        }

        final int[] myArray = new int[] { 0, 1, 2, 3, 4 };
        int[] arrRef2 = myArray;
        arrRef2[3] = 99;
        System.out.println("myArray[3]: " + myArray[3]);

        String str1 = new String("abc");
        String str2 = new String(str1);
        System.out.println("str1 " + str1);
        System.out.println("str2 " + str2);

        Character ch = new Character('a');
        char charValue = ch.charValue();
        String chstr = ch.toString();
        System.out.println(ch.SIZE);
        Integer in = new Integer(3);
        System.out.println(in.SIZE);
        System.out.println((int) charValue);
        System.out.println(chstr.length());

        final String s1 = new String("111");
        final String s2 = new String("111");
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        if (s1.equals(s2)) {
            System.out.println("equal, Is the same string.");
        }
        if (s1 == s2) {
            System.out.println("==, Is the same string.");
        }

        final Integer i1 = new Integer(new String("111"));
        final Integer i2 = new Integer(new String("111"));
        System.out.println("i1.hashCode(): " + i1.hashCode());
        System.out.println("i2.hashCode(): " + i2.hashCode());
        if (i1.equals(i2)) {
            System.out.println("equal, Is the same integer.");
        }
        if (i1 == i2) {
            System.out.println("==, Is the same integer.");
        }
    }
}

class Test {
    private int a;
    private int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test [a=" + a + ", b=" + b + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + a;
        result = prime * result + b;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Test other = (Test) obj;
        if (a != other.a)
            return false;
        if (b != other.b)
            return false;
        return true;
    }
}
