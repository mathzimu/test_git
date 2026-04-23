package io.reader.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Test {
    public static void main(String[] args) {
        parseWithStringReader();
    }

    public static void parseWithStringReader() {
        String yaml = """
                server:
                  port: 8080
                spring:
                  datasource:
                    url: jdbc:mysql://localhost:3306/test
                """;

        try (StringReader sr = new StringReader(yaml)
             ; BufferedReader br = new BufferedReader(sr)) {
            br.lines()
                    .map(String::trim)
                    .filter(line-> !line.isEmpty() && !line.startsWith("#"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
