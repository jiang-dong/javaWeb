package datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //1导入jar包
        //2.定义配置文件
        Properties pro = new Properties();
        //InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
       // pro.load(is);


        URL resource = DruidDemo.class.getClassLoader().getResource("datasource/druid.properties");
        pro.load(new FileReader(resource.getPath()));
        
        //3.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

}
