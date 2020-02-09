package JDBC.cn.wzk.jdbc.domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo4 {
    public static void main(String[] args){
        List<Emp> list = findAll();
        for(int i = 0 ; i < list.size() ; i ++){
            System.out.println(list.get(i));
        }
    }

    public static List<Emp> findAll(){
        List<Emp> result = new ArrayList();
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","root");
            statement = conn.createStatement();
            res = statement.executeQuery("select * from emp");
            while(res.next()){
                Emp emp = new Emp();
                emp.setId(res.getInt("id"));
                emp.setEname(res.getString(2));
                emp.setJobId(res.getInt(3));
                emp.setMgr(res.getInt(4));
                emp.setJoinDate(res.getDate(5));
                emp.setBonus(res.getDouble(6));
                emp.setDeptId(res.getInt(7));
                result.add(emp);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
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
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
