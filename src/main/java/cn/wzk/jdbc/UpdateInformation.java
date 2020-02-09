package cn.wzk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateInformation {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try{
            long start = System.currentTimeMillis();
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
            conn.setAutoCommit(false);
            for(int i = 1 ; i <= 20000000 ; i ++) {
                String sql = "update user set name = '" + ("王志康" + i) + "' where name = '" + ("wang" + i) + "'";
                System.out.println(sql);
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.addBatch();

                    if (i % 10000 == 0) {
                        preparedStatement.executeBatch();
                        conn.commit();
                        preparedStatement.clearBatch();
                        long end = System.currentTimeMillis();
                        System.out.println("修改10000条数据耗费" + (end - start) + "毫秒");
                    }

            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
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
