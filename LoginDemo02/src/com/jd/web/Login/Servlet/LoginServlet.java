package com.jd.web.Login.Servlet;

import com.jd.web.Login.dao.UserDao;
import com.jd.web.Login.domin.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //Map<String, String[]> parameterMap = request.getParameterMap();

        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

        User u = new User(userName, passWord);

        UserDao userDao = new UserDao();

        User user = userDao.queryUser(u);
        System.out.println(user);

        if (user != null) {
            request.setAttribute("User", user);
            request.getRequestDispatcher("SuccessServlet").forward(request, response);
        } else {
            //request.getRequestDispatcher("Login/FailedServlet").forward(request,response);
            response.sendRedirect("/Login02/FailedServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
