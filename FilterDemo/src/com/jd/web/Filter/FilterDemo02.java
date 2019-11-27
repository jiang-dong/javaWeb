package com.jd.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/a")
public class FilterDemo02 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    public void destroy() {
        System.out.println("destroy...");
    }

}
