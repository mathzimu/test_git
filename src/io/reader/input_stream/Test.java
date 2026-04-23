package io.reader.input_stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) throws IOException {
        readFromProcess();
    }

    public static void readFromProcess() throws IOException {
        Process process = new ProcessBuilder("ps", "aux").start();

        try (Reader reader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {

            br.lines()
                    .filter(line -> line.contains("java"))
                    .forEach(System.out::println);
        }
    }
}
