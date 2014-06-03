package com.an.antry.java.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

// java 追加内容到文件末尾的几种常用方法
//http://blog.csdn.net/jsjwk/article/details/3942167
public class WriteStreamAppend {
    /**
     * Use FileOutputStream, set the second argument of FileOutputStream is
     * true.
     * 
     * @param fileName
     * @param content
     */
    public static void method1(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(conent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Use FileWriter, set the second argument of FileOutputStream is true.
     * 
     * @param fileName
     * @param content
     */
    public static void method2(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use RandomAccessFile
     * 
     * @param fileName
     * @param content
     */
    public static void method3(String fileName, String content) {
        try {
            // Open with read and write
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // File length, byte size
            long fileLength = randomFile.length();
            // Move the pointer to the end
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        method1("appendFile.txt", "Append to the end\n");
        System.out.println("end");
    }
}
