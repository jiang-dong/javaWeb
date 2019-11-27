package com.jd.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("zhangsan".equals(username)&&"123".equals(password)){
            //保存信息到session
            HttpSession session = request.getSession();
            session.setAttribute("username","username");
            session.setAttribute("password","password");
            request.getRequestDispatcher("IndexServlet").forward(request,response);

        }else{
            System.out.println("URL虚拟目录地址："+request.getContextPath());
            response.sendRedirect(request.getContextPath()+"/login.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
