package com.bookstore.filter.gzip;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GzipResponseStream extends ServletOutputStream {

    protected ByteArrayOutputStream baos;
    protected GZIPOutputStream gzipOutputStream;
    protected HttpServletResponse response;
    protected ServletOutputStream outputStream;
    protected boolean closed;

    public GzipResponseStream(HttpServletResponse response) throws IOException {
        this.response = response;
        outputStream = response.getOutputStream();
        baos = new ByteArrayOutputStream();
        gzipOutputStream = new GZIPOutputStream(baos);
        closed = false;
    }

    public void close() throws IOException {
        if (closed) {
            throw new IOException("This output stream has already been closed");
        }
        gzipOutputStream.finish();

        byte[] bytes = baos.toByteArray();

        response.addHeader("Content-Length", Integer.toString(bytes.length));
        response.addHeader("Content-Encoding", "gzip");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        closed = true;
    }

    public void flush() throws IOException {
        if (closed) {
            throw new IOException("Cannot flush a closed output stream");
        }
        gzipOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        if (closed) {
            throw new IOException("Cannot write to a closed output stream");
        }
        gzipOutputStream.write((int) b);
    }

    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte b[], int off, int len) throws IOException {
        if (closed) {
            throw new IOException("Cannot write to a closed output stream");
        }
        gzipOutputStream.write(b, off, len);
    }

    public boolean isClosed() {
        return closed;
    }

    public void reset() {
        //NOOP
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
