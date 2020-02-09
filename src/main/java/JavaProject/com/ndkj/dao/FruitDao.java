package JavaProject.com.ndkj.dao;

import JavaProject.com.ndkj.pojo.Fruit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class FruitDao extends DataBaseDao{
    public int add(Fruit fruit){
        String sql = "insert into fruit values(?,?,?,?)";
        DataBaseDao baseDao = new DataBaseDao();
        int res = baseDao.saveOrUpdateOrDelete(sql,fruit.getId(),fruit.getFruit_name(),fruit.getPrice(),fruit.getUnit());
        return res;
    }
    public int delete(int id){
        String sql = "delete from fruit where id = ?";
       return super.saveOrUpdateOrDelete(sql,id);
    }
    public List<Fruit> queryId(int id){
        String sql = "select * from fruit where id = ?";
        List<Fruit> res = null;  //查询出的结果存放的地方
        Connection conn = null; //数据库连接
        PreparedStatement preparedStatement = null; //数据库执行SQL的对象
        ResultSet resultSet = null; //查询出来的结果
        try{
            conn = getConnection();
            preparedStatement = conn.prepareStatement(sql,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.isFirst()){
                    res = new ArrayList<Fruit>();
                }
                Fruit fruit = new Fruit();
                fruit.setId(resultSet.getInt("id"));
                fruit.setFruit_name(resultSet.getString("fruit_name"));
                fruit.setPrice(resultSet.getDouble("price"));
                fruit.setUnit(resultSet.getString("unit"));
                res.add(fruit);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DataBaseDao.release(conn,preparedStatement,resultSet);
        }
        return res;
    }
    public int update(Fruit fruit){
        String sql = "update fruit set id = ? , fruit_name = ? , price = ? , unit = ? where id = ?";
        return super.saveOrUpdateOrDelete(sql,fruit.getId(),fruit.getFruit_name(),fruit.getPrice(),fruit.getUnit(),fruit.getId());
    }
    public List<Fruit> query(){
        String sql = "select * from fruit";
        List<Fruit> res = null;  //查询出的结果存放的地方
        Connection conn = null; //数据库连接
        PreparedStatement preparedStatement = null; //数据库执行SQL的对象
        ResultSet resultSet = null; //查询出来的结果
        try{
              conn = getConnection();
              preparedStatement = conn.prepareStatement(sql);
              resultSet = preparedStatement.executeQuery();
              while(resultSet.next()){
                  if(resultSet.isFirst()){
                      res = new ArrayList<Fruit>();
                  }
                  Fruit fruit = new Fruit();
                  fruit.setId(resultSet.getInt("id"));
                  fruit.setFruit_name(resultSet.getString("fruit_name"));
                  fruit.setPrice(resultSet.getDouble("price"));
                  fruit.setUnit(resultSet.getString("unit"));
                  res.add(fruit);
              }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DataBaseDao.release(conn,preparedStatement,resultSet);
        }
        return res;
    }
}
