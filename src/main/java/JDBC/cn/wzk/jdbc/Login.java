package JDBC.cn.wzk.jdbc;

import JDBC.cn.wzk.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String username = sc.next();
        String password = sc.next();
        Login login = new Login();
        if(login.login(username,password)){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }
    }

    public boolean login(String username,String password){
        if(username == null && password == null){
            return false;
        }
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        try {
            conn = JDBCUtil.getConnection();
            statement = conn.createStatement();
            res = statement.executeQuery("select * from where username = '" + username + "'and '" + password + "'");
            if(res.wasNull()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(res,statement,conn);
        }
        return true;
    }
}
