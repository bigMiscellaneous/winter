package JavaProject.com.ndkj.dialog;
import JavaProject.com.ndkj.pojo.Fruit;
import JavaProject.com.ndkj.service.FruitService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
public class FruitDialog extends AbstractMainDialog{
    public FruitDialog(Frame parent,boolean isModel){
        super(parent,isModel);
        queryFruit();//初始化的时候就查询数据
    }
    @Override
    protected void addFruit() {
        Fruit fruit = new Fruit();
        fruit.setId(Integer.parseInt(addIdText.getText().trim()));
        fruit.setFruit_name(addNameText.getText().trim());
        fruit.setPrice(Double.parseDouble(addPriceText.getText().trim()));
        fruit.setUnit(addUnitText.getText().trim());
        if(fruitService.save(fruit)){
            JOptionPane.showMessageDialog(this,"添加成功");
            queryFruit();
            addIdText.setText("");
            addNameText.setText("");
            addPriceText.setText("");
            addUnitText.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this,"添加失败，请更换水果编号");
        }
    }
    @Override
    protected void updateFruit() {
        Fruit fruit = new Fruit();
        fruit.setId(Integer.parseInt(updateIdText.getText().trim()));
        fruit.setFruit_name(updateNameText.getText().trim());
        fruit.setPrice(Double.parseDouble(updatePriceText.getText().trim()));
        fruit.setUnit(updateUnitText.getText().trim());
        if(fruitService.update(fruit)){
            JOptionPane.showMessageDialog(this,"修改成功");
            queryFruit();
            updateIdText.setText("");
            updateNameText.setText("");
            updatePriceText.setText("");
            updateUnitText.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this,"更新失败，请更换水果编号");
        }
    }
    @Override
    protected void deleteFruit() {
        int id = Integer.parseInt(deleteIdText.getText().trim());
        if(fruitService.delete(id)){
            JOptionPane.showMessageDialog(this,"修改成功");
            queryFruit();
            deleteIdText.setText("");
        }
        else{
            JOptionPane.showMessageDialog(this,"更新失败，请更换水果编号");
        }
    }
    FruitService fruitService = new FruitService();
    //查询方法
    @Override
    protected void queryFruit() {
        String[] title = {"水果编号","水果名称","水果单价","计价单位"};
        String[][] data = fruitService.getFruitData();
        TableModel tableModel = new DefaultTableModel(data,title);
        table.setModel(tableModel);
    }
    @Override
    public void queryId(){
        String[] title = {"水果编号","水果名称","水果单价","计价单位"};
        String[][] data = fruitService.getFruitData();
        TableModel tableModel = new DefaultTableModel(data,title);
        table.setModel(tableModel);
    }
}
