package JDBC;

import java.sql.*;
import java.util.Scanner;

public class jdbcdemo7 {
    public static void main(String[] args) {
        //键盘录入  接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        //2.调用方法
        boolean flag = new jdbcdemo7().login(username, password);

        if (flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("密码错误");
        }

    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库是否登录成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        //1/获取数据库连接
        try {
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from user where username=? and password =? ";

            pstmt = conn.prepareStatement(sql);
            //给？赋值
            pstmt.setString(1,username );
            pstmt.setString(2, password);

            //执行sql
            rs = pstmt.executeQuery();

            return rs.next();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }


        return false;
    }

}
