package JDBC;

import java.sql.*;

public class jdbcdemo6 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///jiangdong", "root", "123456");

            String sql = " select * from user";

            stmt = conn.createStatement();

            //执行sql
            rs = stmt.executeQuery(sql);

            //处理结果
            rs.next();
            int id = rs.getInt(1);
            String name = rs.getString("username");
            String password = rs.getString(3);

            System.out.println(id + "---" + name + "---" + password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }


    }
}
