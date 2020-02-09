package cn.wzk.jdbc;
import java.sql.*;
public class AddInformation {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            long start = System.currentTimeMillis();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "root");
            conn.setAutoCommit(false);
            preparedStatement = conn.prepareStatement("insert into user(id,name,password,sex,age) values(?,?,?,?,?)");
            for(int i = 1; i <= 20000000 ; i ++) {
                if (i % 2 != 0) {
                    preparedStatement.setInt(1, i);
                    preparedStatement.setString(2, "wang" + i);
                    preparedStatement.setString(3, "" + i);
                    preparedStatement.setString(4, "男");
                    preparedStatement.setInt(5, i);
                } else {
                    preparedStatement.setInt(1, i);
                    preparedStatement.setString(2, "wang" + i);
                    preparedStatement.setString(3, "" + i);
                    preparedStatement.setString(4, "女");
                    preparedStatement.setInt(5, i);
                }
                preparedStatement.addBatch();
                if (i % 10000 == 0) {
                    preparedStatement.executeBatch();
                    conn.commit();
                    preparedStatement.clearBatch();
                    long end = System.currentTimeMillis();
                    System.out.println("插入10000条数据花费：" + (end - start) + "毫秒");
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
