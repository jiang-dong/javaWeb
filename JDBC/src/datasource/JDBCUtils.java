package datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid 连接池工具类
 */
public class JDBCUtils {

    private  static  DataSource ds;

    static {

        try {
            //加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("datasource/druid.properties"));
            //获取数据库连接池
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return
     * @throws SQLException
     */

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


    /**
     * 关闭资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        close(null,stmt,conn);
    }


    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }


        if(conn != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }



    public static DataSource getDataSource(){
        return ds;
    }

}
