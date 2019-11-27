package com.jd.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");

        response.setContentType("text/html;charset=utf-8");
        if(username !=null && !"".equals(username)){
            response.getWriter().write("欢迎登录成功");
        }else{
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
*/

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().write("欢迎登录成功");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
