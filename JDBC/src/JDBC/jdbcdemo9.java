package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcdemo9 {
    public static void main(String[] args) {
        //键盘录入  接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();

        //2.调用方法
        boolean flag = new jdbcdemo9().login(username, password);

        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("密码错误");
        }

    }

    public boolean  login(String username,String password){
        if(username==null  || password == null){
            return false;
        }
        //连接数据库是否登录成功
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;


        //1/获取数据库连接
        try {
            conn =JDBCUtils.getConnection();
            //2.定义sql
            String sql ="select * from user where username='"+username+"' and password ='"+password+"' ";
            //3.获取执行sql的对象
             stmt = conn.createStatement();
            //4.执行查询
             rs = stmt.executeQuery(sql);

            return  rs.next();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }


        return false;
    }

}
