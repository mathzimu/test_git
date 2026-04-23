package io.reader.buffered;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestBufferedReader {
    public static void main(String[] args) throws IOException {
        readLargeFileWithLines();
    }
    public static void readLargeFileWithLines() throws IOException {
        Path path = Path.of("/Users/ryanli/Downloads/test_git/src/io/reader/buffered/access.log");

        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            int linCount = 0;
            while((line = reader.readLine()) != null) {
                if (line.contains(" 404 ")) {
                    System.out.println("404 found: " + line);
                }
                linCount++;
                if (linCount % 100_000 == 0) {
                    System.out.println("Processed " + linCount + "lines...");
                }
            }
            System.out.println("Total lines: " + linCount);
        }
    }
}
