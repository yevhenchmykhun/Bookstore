package com.yevhenchmykhun.filter.cache;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CacheResponseWrapper extends HttpServletResponseWrapper {

    protected HttpServletResponse originResponse;
    protected ServletOutputStream outputStream;
    protected PrintWriter writer;
    protected OutputStream cache;

    public CacheResponseWrapper(HttpServletResponse response, OutputStream cache) {
        super(response);
        originResponse = response;
        this.cache = cache;
    }

    public ServletOutputStream createOutputStream()
            throws IOException {
        return new CacheResponseStream(originResponse, cache);
    }

    public void flushBuffer() throws IOException {
        outputStream.flush();
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if (writer != null) {
            throw new IllegalStateException("getWriter() has already been called!");
        }

        if (outputStream == null) {
            outputStream = createOutputStream();
        }
        return outputStream;
    }

    public PrintWriter getWriter() throws IOException {
        if (writer != null) {
            return writer;
        }

        if (outputStream != null) {
            throw new IllegalStateException("getOutputStream() has already been called!");
        }

        outputStream = createOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        return writer;
    }

}
