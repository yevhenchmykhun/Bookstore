package com.bookstore.filter.cache;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/*@WebFilter(filterName = "CacheFilter", urlPatterns = {"*//*"})*/
public class CacheFilter implements Filter {

    ServletContext servletContext;
    FilterConfig filterConfig;
    long cacheTimeout = Long.MAX_VALUE;

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // check if was a resource that shouldn't be cached.
        String realPath = servletContext.getRealPath("");
        String path = filterConfig.getInitParameter(request.getRequestURI());
        if (path != null && path.equals("nocache")) {
            filterChain.doFilter(request, response);
            return;
        }
        path = realPath + path;

        // customize to match parameters
        String id = request.getRequestURI() + request.getQueryString();
        /*// optionally append i18n sensitivity
        String localeSensitive = filterConfig.getInitParameter("locale-sensitive");
        if (localeSensitive != null) {
            StringWriter ldata = new StringWriter();
            Enumeration locales = request.getLocales();
            while (locales.hasMoreElements()) {
                Locale locale = (Locale) locales.nextElement();
                ldata.write(locale.getISO3Language());
            }
            id = id + ldata.toString();
        }*/
        File tempDir = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

        // get possible cache
        String temp = tempDir.getAbsolutePath();
        File file = new File(temp + id);

        // get current resource
        if (path == null) {
            path = servletContext.getRealPath(request.getRequestURI());
        }
        File current = new File(path);

        try {
            long now = System.currentTimeMillis();
            //set timestamp check
            if (!file.exists() || (file.exists() &&
                    current.lastModified() > file.lastModified()) ||
                    cacheTimeout < now - file.lastModified()) {
                String name = file.getAbsolutePath();
                name = name.substring(0, name.lastIndexOf("/") == -1 ? 0 : name.lastIndexOf("/"));
                new File(name).mkdirs();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                CacheResponseWrapper wrappedResponse =
                        new CacheResponseWrapper(response, baos);
                filterChain.doFilter(servletRequest, wrappedResponse);

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            }
        } catch (ServletException e) {
            if (!file.exists()) {
                throw new ServletException(e);
            }
        } catch (IOException e) {
            if (!file.exists()) {
                throw e;
            }
        }

        FileInputStream fis = new FileInputStream(file);
        String mimeType = servletContext.getMimeType(request.getRequestURI());
        response.setContentType(mimeType);
        ServletOutputStream servletOutputStream = servletResponse.getOutputStream();
        for (int i = fis.read(); i != -1; i = fis.read()) {
            servletOutputStream.write((byte) i);
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String cacheTimeout = filterConfig.getInitParameter("cacheTimeout");
        if (cacheTimeout != null) {
            cacheTimeout = Long.toString(60 * 1000 * Long.parseLong(cacheTimeout));
        }
        this.servletContext = filterConfig.getServletContext();
    }

    public void destroy() {
        this.servletContext = null;
        this.filterConfig = null;
    }
}
