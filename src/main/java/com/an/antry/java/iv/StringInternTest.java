package com.an.antry.java.iv;

public class StringInternTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("chaofan").append("wei").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        test1();
        test4();
        test5();
    }

    public static void test1() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");
        System.out.println("==== test1");
        System.out.println(str5.equals(str3));// true
        System.out.println(str5 == str3);// false
        System.out.println(str5.intern() == str3);// true
        System.out.println(str5.intern() == str4);// false
    }

    public static void test4() {
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;
        System.out.println("==== test4");
        System.out.println(b.intern() == a);// fasle
        System.out.println(b.intern() == c);// true
        System.out.println(b.intern() == d);// true 编译期d已确定(修改、赋值)为ab
        System.out.println(b.intern() == f);// false
        System.out.println(b.intern() == a.intern());// true
    }

    public static void test5() {
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";
        System.out.println("==== test5");
        System.out.println(a == b);// true
        System.out.println(a == c);// true
        System.out.println(a == d);// true
        System.out.println(a == e);// true
        System.out.println(c == d);// true
        System.out.println(c == e);// true
    }
}
