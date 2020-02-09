package JDBC.cn.wzk.jdbc;

import java.sql.*;

public class JdbcDemo3 {
    public static void main(String[] args){
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
            statement = conn.createStatement();
            res = statement.executeQuery("select * from account");
            while(res.next()){
                int id = res.getInt(1);
                String name = res.getString("name");
                double balance = res.getDouble(3);
                System.out.println("id：" + id + "  姓名：" + name + "  薪资：" + balance);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(res != null){
                try{
                    res.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
