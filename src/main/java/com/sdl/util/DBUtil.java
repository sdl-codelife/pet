package com.sdl.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
 * 通过读取Properties连接数据库
 */
public class DBUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    /**
     * 静态代码块加载配置文件信息
     */
    static {
        try {
            // 1.通过当前类获取类加载器
            ClassLoader classLoader = DBUtil.class.getClassLoader();
            // 2.通过类加载器的方法获得一个输入流
            InputStream in = classLoader.getResourceAsStream("jdbc.properties");
            // 3.创建一个properties对象(集合)
            Properties props = new Properties();
            // 4.加载输入流
            props.load(in);
            // 5.获取相关参数的值
            driver = props.getProperty("jdbc.driver");
            url = props.getProperty("jdbc.url");
            username = props.getProperty("jdbc.username");
            password = props.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //注册并获取数据库连接
    public static Connection getConnection() throws Exception{
        //1.注册驱动
        Class.forName(driver);
        //2.获取数据库连接
        Connection coon =  DriverManager.getConnection(url, username, password);
        return coon;
    }

    //释放资源
    public static void close(ResultSet rs, Statement st, Connection co) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(co != null) {
                co.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}