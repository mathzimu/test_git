package io.reader;

import java.io.IOException;
import java.io.Reader;

public class SkipBomReader extends Reader {
    private final Reader in;
    private boolean skipped = false;

    public SkipBomReader(Reader in) {
        this.in = in;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (!skipped) {
            in.mark(4);
            int b1 = in.read();
            if (b1 == 0xEF) {
                int b2 = in.read();
                int b3 = in.read();
                if (b2 == 0xBB && b3 == 0xBF) {
                    skipped = true;
                    return in.read(); // 跳过 BOM 后的第一个有效字符
                }
            }
            in.reset();
            skipped = true;
            return b1;
        }
        return in.read();
    }

    @Override
    public void close() throws IOException {

    }
}
