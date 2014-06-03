package com.an.antry.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHrefText {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test1() {
        String content = "<a class=\"abc\" href=\"http://www.baidu.com\">";
        // String content =
        // "<a class=\"abc\" href=\"'http://proxyfreak.org/proxy/7928' target='_blank' style='color:'\">";
        String pattern = "href=\"([^\"]*)\"";
        Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL);
        Matcher m = p.matcher(content);
        if (m.find()) {
            String href = m.group(1);
            System.out.println("url= " + href);
            int s = href.indexOf("http");
            if (s == -1) {
                return;
            }
            int e = href.indexOf(" ");
            if (e != -1) {
                System.out.println(href.substring(s, e - 1).trim());
            } else {
                System.out.println(href.substring(s).trim());
            }
        }
    }

    private static void test2() {
        String input = "'http://proxyfreak.org/proxy/7928' target='_blank' style='color:";
        String pattern = "'(http:.*)'.*target.*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);
        if (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
