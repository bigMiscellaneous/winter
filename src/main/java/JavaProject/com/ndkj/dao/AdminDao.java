package JavaProject.com.ndkj.dao;



import JavaProject.com.ndkj.pojo.Fruit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDao {

    public ArrayList<Fruit> queryAllData(){
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        try{
            conn = DataBaseDao.getConnection();
            statement = conn.createStatement();
            String sql = "select * from fruit";
            res = statement.executeQuery(sql);
            while(res.next()){
                Fruit fruit = new Fruit();
                fruit.setId(res.getInt("id"));
                fruit.setFruit_name(res.getString("fruit_name"));
                fruit.setPrice(res.getDouble("price"));
                fruit.setUnit(res.getString("unit"));
                list.add(fruit);
                return list;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DataBaseDao.release(conn,statement,res);
        }
        return null;
   }

   public void addFruit(Fruit fruit){
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;
        try{
            conn = DataBaseDao.getConnection();
            statement = conn.createStatement();
            String sql = "insert into fruit(id,fruit_name,price,nuit) values(" + fruit.getId() + ",'" + fruit.getFruit_name() + "'," + fruit.getPrice() + ",'" + fruit.getUnit() + "')";
            int num = statement.executeUpdate(sql);
            if(num > 0){
                System.out.println("插入数据成功!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DataBaseDao.release(conn,statement,res);
        }
   }
}
