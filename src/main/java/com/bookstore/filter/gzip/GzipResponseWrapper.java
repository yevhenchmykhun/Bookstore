package com.bookstore.filter.gzip;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class GzipResponseWrapper extends HttpServletResponseWrapper {

    protected HttpServletResponse originResponse;
    protected ServletOutputStream outputStream;
    protected PrintWriter writer;

    public GzipResponseWrapper(HttpServletResponse response) {
        super(response);
        originResponse = response;
    }

    public ServletOutputStream createOutputStream() throws IOException {
        return (new GzipResponseStream(originResponse));
    }

    public void finishResponse() {
        try {
            if (writer != null) {
                writer.close();
            } else {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            //NOOP
        }
    }

    public void flushBuffer() throws IOException {
        outputStream.flush();
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if (writer != null) {
            throw new IllegalStateException("getWriter() has already been called");
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
            throw new IllegalStateException("getOutputStream() has already been called");
        }

        outputStream = createOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        return writer;
    }

    public void setContentLength(int length) {
    }

}
