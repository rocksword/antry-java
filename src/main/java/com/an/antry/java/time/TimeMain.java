package com.an.antry.java.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeMain {
    public static void main(String[] args) {
        try {
            test();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws ParseException {
        String start = "2014-05-20";
        String end = "2014-05-21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long times = sdf.parse(start).getTime();
        System.out.println(times);
        long timee = sdf.parse(end).getTime();
        System.out.println(timee);
        System.out.println((timee - times) / 1000);
    }
}
