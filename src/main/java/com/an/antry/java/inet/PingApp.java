package com.an.antry.java.inet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class PingApp {
    public static void main(String[] args) {
        ping2();
        // ping1();
    }

    private static void ping2() {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        String line = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String ip = "www.baidu.com";
        boolean res = false;
        try {
            process = runtime.exec("ping " + ip);
            is = process.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (line.contains("TTL")) {
                    res = true;
                    break;
                }
            }
            is.close();
            isr.close();
            br.close();
            if (res) {
                System.out.println("Is reachable.");
            } else {
                System.out.println("Not reachable.");
            }
        } catch (IOException e) {
            System.out.println(e);
            runtime.exit(1);
        }
    }

    private static void ping1() {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            // Try to reach the specified address within the timeout
            // periode. If during this periode the address cannot be
            // reach then the method returns false.
            boolean reachable = address.isReachable(1000);
            System.out.println("Is host reachable? " + reachable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
