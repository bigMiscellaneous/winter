package JDBC.cn.wzk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbdDemo2 {
    public static void main(String[] args){
        Connection conn = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
            statement = conn.createStatement();
            int re = statement.executeUpdate("update account set balance = 1500 where name = 'lisi'");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
                if(statement != null){
                    try{
                        statement.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(conn != null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
        }
    }
}
