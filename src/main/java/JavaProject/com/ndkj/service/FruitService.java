package JavaProject.com.ndkj.service;

import JavaProject.com.ndkj.dao.FruitDao;
import JavaProject.com.ndkj.pojo.Fruit;

import java.util.List;

public class FruitService {
    FruitDao fruitDao = new FruitDao();
    public String[][] getFruitData(){
        List<Fruit> list = fruitDao.query();
        if(list == null){
            return null;
        }
        String[][] data = new String[list.size()][4];
        for(int i = 0 ; i < list.size() ; i ++){
            data[i][0] = list.get(i).getId() + "";
            data[i][1] = list.get(i).getFruit_name();
            data[i][2] = list.get(i).getPrice() + "";
            data[i][3] = list.get(i).getUnit();
        }
        return data;
    }



    public boolean save(Fruit fruit){
        return fruitDao.add(fruit) > 0 ? true : false;
    }

    public boolean update(Fruit fruit){
        int res = fruitDao.update(fruit);
        return res > 0 ? true : false;
    }

    public boolean delete(int id){
        return fruitDao.delete(id) > 0 ? true : false;
    }
}
