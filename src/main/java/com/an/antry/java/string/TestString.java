package com.an.antry.java.string;

public class TestString {
    public static void main(String[] args) {
        String line = "<th>aaa</th><th>bbb</th>lll";
        String line2 = line.replace("/th>", "/th>\n");
        System.out.println(line2);
    }

    private static void format() {
        String iv = String.format("%d", Integer.MAX_VALUE); // "2,147,483,647"
        System.out.println(iv);

        String il = String.format("%d", Long.MAX_VALUE); // "2,147,483,647"
        System.out.println(il);
    }
}
