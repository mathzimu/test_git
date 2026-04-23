package io.reader.push_back;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {

    }

    public static boolean looksLikeXml(InputStream is) throws IOException {
        try (PushbackReader pbr = new PushbackReader(new InputStreamReader(is, StandardCharsets.UTF_8),8)) {
            char[] signature = new char[5];
            int len = pbr.read(signature);

            if (len >= 5 && new String(signature).equals("<?xml")) {
                return true;
            }

            for (int i = len - 1; i >= 0; i--) {
                pbr.unread(signature[i]);
            }
            return false;
        }
    }
}
