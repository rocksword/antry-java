package com.an.antry.java.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

public class FileReadMain {
    public static void main(String[] args) throws FileNotFoundException {
        // jsmap.js is under directory: src/main/resource
        URL url = FileReadMain.class.getResource("/fileread/fileread.txt");
        System.out.println("file: " + url.getFile());

        System.out.println("Read by file name.");
        FileReader fr = new FileReader(url.getFile());

        System.out.println("Read by file instance.");
        fr = new FileReader(new File(url.getFile()));

        FileInputStream in = new FileInputStream(url.getFile());
        InputStreamReader isr = new InputStreamReader(in);
        BufferedInputStream bis = new BufferedInputStream(in);
    }
}
