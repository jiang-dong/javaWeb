package com.jd.web.Login.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FailedServlet")
public class FailedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置登录成功响应格式
        response.setContentType("text/html;charset=utf-8");

        //获取响应流
        PrintWriter writer = response.getWriter();
        //响应数据
        writer.write("登陆失败！<a herf='www.baidu.com'>请重新登录</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
