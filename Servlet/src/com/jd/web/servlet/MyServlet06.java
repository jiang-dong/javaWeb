package com.jd.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet06")
public class MyServlet06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1,设置为GBk
        //response.setCharacterEncoding("gbk");
        //response.setCharacterEncoding("utf-8");
        //告诉浏览器，服务器发送的的消息体数据的编码。建议浏览器使用该编码解码

       response.setContentType("text/html;charset=utf-8");


        PrintWriter writer = response.getWriter();
        writer.write("你好，hello world！！！");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
