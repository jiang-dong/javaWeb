package cm.jd.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        if ("张三".equals(userName) && "123".equals(passWord)) {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("SuccessServlet").forward(request, response);
        } else {
            //request.getRequestDispatcher("Login/FailedServlet").forward(request,response);
            response.sendRedirect("/Login/FailedServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
