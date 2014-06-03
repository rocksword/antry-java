package com.an.antry.java.file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileSaveMain {
    public static void main(String[] args) {
        save();
    }

    private static void save() {
        String filename = "data/elbandidodoblementearmado.com.txt";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));) {
            writer.write("Something");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
