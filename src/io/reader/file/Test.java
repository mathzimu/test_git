package io.reader.file;

import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        legacyFileRead();
    }

    public static void legacyFileRead() {
        try (FileReader fr = new FileReader("/Users/ryanli/Downloads/test_git/src/io/reader/file/config.properties")) {
            char[] buffer = new char[8192];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
