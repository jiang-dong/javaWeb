package com.jd.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/IndexServlet")
public class FilterDemo implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //验证是否登录
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //1.获取session
        HttpSession session = request.getSession();
        //2.从session中获取登录用户名
        Object name = session.getAttribute("name");
        //3.判断用户名是否存在
        if (name != null && !"".equals(name)) {//如果登录了，放行
            chain.doFilter(req,resp);
        } else {
            System.out.println("地址"+request.getContextPath());
            //            //如果未登录，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login.html");
        }

    }

    public void destroy() {
    }

}
