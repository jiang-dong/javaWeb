package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcdemo10 {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt1=null;
        PreparedStatement pstmt2=null;


        try {
            //获取连接
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);

            //定义sql
            String sql1 ="update accont set balance= balance-? where id =?";

            String sql2 ="update accont set balance= balance+? where id =?";

            pstmt1 = conn.prepareStatement(sql1);

            pstmt2 = conn.prepareStatement(sql2);


            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setInt(2,2);

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt1,null);
        }


    }

}
