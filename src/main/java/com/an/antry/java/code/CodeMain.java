package com.an.antry.java.code;

import java.io.UnsupportedEncodingException;

public class CodeMain {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "字符串编码转换";
        // 这里写原编码方式
        byte[] temp = str.getBytes("utf-8");
        // 这里写转换后的编码方式
        byte[] newtemp = new String(temp, "utf-8").getBytes("gbk");
        // 这里写转换后的编码方式
        String newStr = new String(newtemp, "gbk");
        System.out.println(newStr);

        System.out.println(decode("\u5fb7\u4f26\u7279"));
        System.out.println(decode("(27)\u6362\u5165(11)\u6362\u51fa"));
    }

    public static String decode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int max = unicodeStr.length();
        for (int i = 0; i < max; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < max - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U'))) {
                    try {
                        result.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException e) {
                        result.append(unicodeStr.charAt(i));
                    }
                } else {
                    result.append(unicodeStr.charAt(i));
                }
            } else {
                result.append(unicodeStr.charAt(i));
            }
        }
        return result.toString();
    }
}