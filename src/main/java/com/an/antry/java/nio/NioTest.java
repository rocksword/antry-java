package com.an.antry.java.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NioTest {
    public static void main(String[] args) throws MalformedURLException, FileNotFoundException, IOException {
        // download_1();
        download_2();
    }

    static void download_1() throws MalformedURLException, IOException, FileNotFoundException {
        URL url = new URL("http://www.baidu.com");
        try (InputStream is = url.openStream(); FileOutputStream fos = new FileOutputStream("D:\\baidu_nio.html")) {
            ReadableByteChannel rbc = Channels.newChannel(is);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    static void download_2() {
        Path path = new File("D:\\wkyc.com.html").toPath();
        try (InputStream is = new URL("http://www.alexa.com/siteinfo/wkyc.com").openStream();) {
            Files.copy(is, path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
