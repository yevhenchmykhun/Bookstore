package com.yevhenchmykhun.filter.gzip;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "GzipFilter", urlPatterns = {"/*"})
public class GzipFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            String ae = request.getHeader("accept-encoding");
            if (ae != null && ae.indexOf("gzip") != -1) {
                GzipResponseWrapper responseWrapper = new GzipResponseWrapper(response);
                chain.doFilter(req, responseWrapper);
                System.out.println("Compressing...");
                responseWrapper.finishResponse();
                return;
            }
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        //NOOP
    }

    public void destroy() {
        //NOOP
    }

}
