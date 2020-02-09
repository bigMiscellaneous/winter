package JavaProject.com.ndkj.dao;

import JavaProject.com.ndkj.pojo.Fruit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DataBaseDao {
    private static final String URL = "jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=utf8";
    private static final String userName = "root";
    private static final String password = "root";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int saveOrUpdateOrDelete(String sql,Object... para){
        int res = 0;
        Connection conn = DataBaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //告诉数据库准备执行这条SQL
            preparedStatement = conn.prepareStatement(sql);
            for(int i = 0 ; i < para.length ; i ++){
                preparedStatement.setObject(i + 1,para[i]);
            }
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.release(conn,preparedStatement,null);
        }
        return res;
    }
    public int queryOne(String sql){
        int res = 0;
        Connection conn = DataBaseDao.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            //告诉数据库准备执行这条SQL
            preparedStatement = conn.prepareStatement(sql);
            res = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.release(conn,preparedStatement,null);
        }
        return res;
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void release(Connection conn, Statement statement, ResultSet res) {
        try{
            if(res != null && !res.isClosed()){
                res.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(statement != null && !statement.isClosed()){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
