package JDBC.cn.wzk.jdbc.util;

import JDBC.cn.wzk.jdbc.domain.Emp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        try {
           conn = JDBCUtils.getConnection();
           statement = conn.createStatement();
           res = statement.executeQuery("select * from emp");
           Emp emp = null;
            List<Emp> result = new ArrayList<Emp>();
           while(res.next()){
               int id = res.getInt(1);
               String ename = res.getString(2);
               int jobId = res.getInt(3);
               int mgr = res.getInt(4);
               Date joinDate = res.getDate(5);
               double bonus = res.getDouble(6);
               int deptId = res.getInt(7);
               emp.setId(id);
               emp.setEname(ename);
               emp.setJobId(jobId);
               emp.setMgr(mgr);
               emp.setJoinDate(joinDate);
               emp.setBonus(bonus);
               emp.setDeptId(deptId);
               result.add(emp);
           }
            System.out.println(result);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JDBCUtils.close(res,statement,conn);
        }
    }
}
