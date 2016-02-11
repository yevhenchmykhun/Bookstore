package com.yevhenchmykhun.filter.cache;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class CacheResponseStream extends ServletOutputStream {

    protected boolean closed;
    protected HttpServletResponse response;
/*    protected ServletOutputStream outputStream;*/
    protected OutputStream cache;

    public CacheResponseStream(HttpServletResponse response, OutputStream cache) throws IOException {
        closed = false;
        this.response = response;
        this.cache = cache;
    }

    @Override
    public void write(int b) throws IOException {
        if (closed) {
            throw new IOException("Cannot write to a closed output stream");
        }
        cache.write((byte) b);
    }

    @Override
    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        if (closed) {
            throw new IOException("Cannot write to a closed output stream");
        }
        cache.write(b, off, len);
    }

    public void close() throws IOException {
        if (closed) {
            throw new IOException("This output stream has already been closed");
        }
        cache.close();
        closed = true;
    }

    public void flush() throws IOException {
        if (closed) {
            throw new IOException("Cannot flush a closed output stream");
        }
        cache.flush();
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        //NOOP
    }
}
