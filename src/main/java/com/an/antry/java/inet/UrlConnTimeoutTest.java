package com.an.antry.java.inet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnTimeoutTest {
    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void run() throws MalformedURLException, IOException {
        String rawLink = "https://www.facebook.com/gwhma";
        URL url = new URL(rawLink);
        String urlStr = url.toString();
        if (urlStr == null) {
            return;
        }
        System.out.println("open conn...");
        long t1 = System.currentTimeMillis();
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        String contentType = conn.getContentType();
        System.out.println("Time: " + (System.currentTimeMillis() - t1));
        System.out.println("contentType: " + contentType);
    }
}
