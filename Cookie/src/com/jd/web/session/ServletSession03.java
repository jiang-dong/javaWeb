package com.jd.web.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//需求 1.访问一个Servlet，判断用户是否登陆
// 登陆，返回给浏览器对应的信息 未登陆，跳转到登陆页面
// 2.登陆页面输入用户名和密码登陆 登陆成功，
// 保存用户名到session中，再跳转到之前的Servlet中 登陆失败，重新跳回到登录页面

@WebServlet("/ServletSession03")
public class ServletSession03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
