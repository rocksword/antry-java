package com.an.antry.java.network.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class FileIoMain {
    public static void main(String[] args) {
        output();

        System.out.println("Read file:");
        read();

        System.out.println("Chain");
        chain();
    }

    private static void output() {
        try (OutputStream out = new FileOutputStream("D:\\test_output.txt");
                OutputStreamWriter w = new OutputStreamWriter(out, "utf8");) {
            w.write("abc\n");
            w.write("def\n");
            w.write("ghi\n");
            w.write("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void stringRead() {
        StringReader sr = new StringReader("abc");
    }

    static void read() {
        try (BufferedReader read = new BufferedReader(new FileReader("D:\\test_output.txt"));) {
            String line = null;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void chain() {
        try (InputStream in = new BufferedInputStream(new FileInputStream("D:\\test_output.txt"));) {
            byte[] b = new byte[1024];
            in.read(b);
            String out = new String(b);
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
