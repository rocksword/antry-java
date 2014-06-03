package com.an.antry.java.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaIOTest {
    public static void main(String[] args) {
        JavaIOTest test = new JavaIOTest();
        try {
            test.read(new URL("http://drdelivery.com"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(URL url) throws IOException {

        long t1 = System.currentTimeMillis();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        long t2 = System.currentTimeMillis();

        try (InputStream input = conn.getInputStream();) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] b = new byte[1024 * 8 * 8];
            int len = -1;
            while ((len = input.read(b)) != -1) {
                System.out.println("len: " + len);
                out.write(b, 0, len);
            }
            long t3 = System.currentTimeMillis();
            System.out.println("2: " + (t3 - t2));
            String re = new String(out.toByteArray());
            System.out.println("total: " + re.length());
            return re;
        } catch (Exception e) {
            return null;
        }
    }
}
