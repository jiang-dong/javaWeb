package com.jd.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/MyServlet02")
public class MyServlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体
        //获取字符流
/*        BufferedReader reader = request.getReader();
        String line =null;
        while ( (line=reader.readLine()) !=null){
            System.out.println(line);
        }*/

        String username = request.getParameter("userName");
        System.out.println("doPost 方式获取参数"+username);
        String password = request.getParameter("passWord");
        System.out.println(password);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("doGet 方式获取参数"+username);
        String password = request.getParameter("passWord");
        System.out.println(password);
    }
}
