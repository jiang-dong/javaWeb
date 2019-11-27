package datasource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /*
        完成account表添加一条记录
         */
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //1获取连接
            conn = JDBCUtils.getConnection();

            //2定义sql语句
            String sql ="insert into accont value(null,?,?)";
            //获取pstmt对象
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,"王五");
            pstmt.setDouble(2,3000);

            int count =pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
