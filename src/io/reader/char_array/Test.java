package io.reader.char_array;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        char[] hugeText = new char[1_000_000];
        processLargeCharArray(hugeText);
    }

    public static void processLargeCharArray(char[] hugeText) throws IOException {
        try (CharArrayReader charArrayReader = new CharArrayReader(hugeText)
             ; BufferedReader br = new BufferedReader(charArrayReader,32*1024)) {
            long start = System.nanoTime();
            long count = br.lines().count();


            long timeMs = (System.nanoTime() - start) / 1_000_000;

            System.out.printf("Processed %,d lines in %d ms%n", count, timeMs);
        }
    }
}
