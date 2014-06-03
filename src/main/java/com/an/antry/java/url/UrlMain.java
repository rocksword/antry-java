package com.an.antry.java.url;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlMain {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URL url = new URL("https://baidu.com/news");
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("file: " + url.getFile());
        System.out.println("path: " + url.getPath());
        System.out.println("URL str: " + url.toString());
        System.out.println("URI str: " + url.toURI().toString());

        url = UrlMain.class.getResource("/fileread/fileread.txt");
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("file: " + url.getFile());
        System.out.println("path: " + url.getPath());
        System.out.println("URL str: " + url.toString());
        System.out.println("URI str: " + url.toURI().toString());
    }
}
