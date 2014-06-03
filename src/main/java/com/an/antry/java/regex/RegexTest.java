/** Copyright 2014 Dell SonicWALL, Inc. All rights reserved. **/
package com.an.antry.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author adong
 * 
 */
public class RegexTest {

    public static void main(String[] args) {
        String input = "'http://proxyfreak.org/proxy/7928' target='_blank' style='color:";
        String pattern = "http://(.*)";
        Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL);
        Matcher m = p.matcher(input);
        if (m.find()) {
            System.out.println("url=" + m.group(1));
        }

        String hrefStr = "url=http://ab.coma,";
        int s = hrefStr.indexOf("url=http");
        int e = hrefStr.indexOf(",");
        if (s != -1 && e != -1 && e > s) {
            hrefStr = hrefStr.substring(s + 4, e);
        }
        System.out.println(hrefStr);
    }
}
