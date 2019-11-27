package com.jd.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 2.如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串。
 */

@WebServlet("/ServletCookie02")
public class ServletCookie02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = false;
        //获取cookie对象
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        //遍历cookie数组
        if (cookies != null ) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                //不是第一次访问，获取上次访问时间
                if (name.equals("lastTime")) {
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("欢迎回来，您上次访问时间为:" + value);

                    flag=true;
                    //更新最新访问时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
                    String time = simpleDateFormat.format(date);
                    //为了避免乱码
                    time = URLEncoder.encode(time, "utf-8");

                    //设置cookie值，重新发送cookie
                    cookie.setValue(time);
                    response.addCookie(cookie);

                    break;
                }

            }

        }

        //是第一次访问，获取上次访问时间
        if (cookies == null || cookies.length == 0 || flag == false) {


            //更新最新访问时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH时mm分ss秒");
            String time = simpleDateFormat.format(date);

            time = URLEncoder.encode(time, "utf-8");

            //设置cookie值，重新发送cookie
            Cookie cookie = new Cookie("lastTime", time);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎首次访问</h1>");


        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }

}
