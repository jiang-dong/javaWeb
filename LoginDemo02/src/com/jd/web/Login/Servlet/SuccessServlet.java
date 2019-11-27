package com.jd.web.Login.Servlet;

import com.jd.web.Login.domin.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置登录成功响应格式
        response.setContentType("text/html;charset=utf-8");
        //获取用户信息
        User user = (User)request.getAttribute("User");
        //获取响应流
        PrintWriter writer = response.getWriter();
        writer.write(user.getUsername()+"欢迎登录！！");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
