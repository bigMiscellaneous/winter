package JDBC.cn.wzk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo {

    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
        //定义sql语句
        String sql = "update account set balance = 1000 where id = 1";
        //获取执行sql的对象
        Statement statement =  conn.createStatement();
        //执行sql
        int res = statement.executeUpdate(sql);
        //处理结果
        System.out.println(res);
        //释放资源
        statement.close();
        conn.close();
    }
}
