package com.an.antry.java.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAdd {
    public static void main(String[] args) throws UnknownHostException {
        new IpAdd().test();
    }

    private void test() throws UnknownHostException {
        if (InetAddress.getByName("192.168.0.1").isSiteLocalAddress()) {
            System.out.println("Site local.");
        }
        if (InetAddress.getByName("10.103.67.5").isSiteLocalAddress()) {
            System.out.println("Site local.");
        }
        if (InetAddress.getByName("192.168.0.1").isLinkLocalAddress()) {
            System.out.println("Link local.");
        }
        if (InetAddress.getByName("127.0.0.4").isLoopbackAddress()) {
            System.out.println("Loop back.");
        }
        InetAddress ipa = InetAddress.getByName("18.18.18.18");
        System.out.println(ipa.getHostAddress());
    }
}
