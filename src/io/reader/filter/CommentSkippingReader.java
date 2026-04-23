package io.reader.filter;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CommentSkippingReader extends FilterReader {
    public CommentSkippingReader(Reader in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.read();
        if (c == '/') {
            int next = super.read();
            if (next == '/') {
                while ((c = super.read()) != -1 && c != '\n') {}
                return read();
            }
            // unread(next);
        }
        return c;
    }
}
