package com.jd.web.session;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletSession01")
public class ServletSession01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用session共享数据，一次会话多次请求共享
        HttpSession session = request.getSession();

        session.setAttribute("mgs","name");

        //一个作用范围内共享数据
        //request.setAttribute();

        //javaWeb项目内共享
        //ServletContext servletContext = request.getServletContext();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
