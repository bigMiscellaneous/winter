package JDBC.cn.wzk.jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        //读取资源文件，获取值
        try {
            //创建Properties集合类
            Properties properties = new Properties();
            //获取src路径下的文件方式 -->ClassLoader类加载器
            ClassLoader loader = JDBCUtils.class.getClassLoader();
            URL url1 = loader.getResource("jdbc.properties");
            //properties.load(new FileReader("F:\\wintervacation\\src\\jdbc.properties"));

            String path = url1.getPath();
            System.out.println(path);
            //加载文件
            properties.load(new FileReader(path));
            //获取数据，赋值
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement statement,Connection conn){
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet res, Statement statement, Connection conn){
        if(res != null){
            try{
                res.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
