package com.jd.web.Login.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCUtils {

        private static DataSource ds =null;
        static {
                try {
                        Properties p =new Properties();
                        InputStream is=JDBCUtils.class.getClassLoader().getResourceAsStream("Driud.properties");
                        p.load(is);
                        ds = DruidDataSourceFactory.createDataSource(p);
                        System.out.println(ds);
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        /**
         * 返回连接池
         * @return
         */
        public static DataSource getDs(){
                return ds;
        }

        public static Connection getConnction() throws SQLException {
                return ds.getConnection();
        }








}
