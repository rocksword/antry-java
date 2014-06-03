package com.an.antry.java.file;

import java.net.URL;

public class FileLineIteratorMain {

    public static void main(String[] args) {
        URL url = FileLineIteratorMain.class.getResource("/log4j.properties");
        String filepath = url.getFile();
        System.out.println(filepath);
        FileLineIterator it = new FileLineIterator(filepath);
        String line = null;
        while ((line = it.nextLine()) != null) {
            System.out.println(line);
            break;
        }
        it.close();
    }
}
