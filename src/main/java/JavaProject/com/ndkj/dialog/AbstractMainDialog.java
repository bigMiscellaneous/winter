package JavaProject.com.ndkj.dialog;

import JavaProject.com.ndkj.util.GUITool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
public abstract class AbstractMainDialog  extends JDialog {
    private JLabel tabelLabel = new JLabel("水果列表");
    private JLabel idLabel = new JLabel("水果编号");
    private JLabel nameLabel = new JLabel("水果名称");
    private JLabel priceLabel = new JLabel("水果单价");
    private JLabel unitLabel = new JLabel("计价单位");
    private JButton addButton = new JButton("添加水果");
    private JButton updateButton = new JButton("修改水果");
    private JButton deleteButton = new JButton("删除水果");
    private JButton queryButton = new JButton("查询水果");
    protected JTextField addIdText = new JTextField();
    protected JTextField addNameText = new JTextField();
    protected JTextField addPriceText = new JTextField();
    protected JTextField addUnitText = new JTextField();
    protected JTextField updateIdText = new JTextField();
    protected JTextField updateNameText = new JTextField();
    protected JTextField updatePriceText = new JTextField();
    protected JTextField updateUnitText = new JTextField();
    protected JTextField deleteIdText = new JTextField();
    protected JTextField queryIdText = new JTextField();
    //水果列表表格
    protected JTable table = new JTable();
    //水果列表表格并带滚动条的容器
    private JScrollPane scrollPane = new JScrollPane(table);

    public AbstractMainDialog(Frame parent,boolean isModel){
        super(parent,isModel);
        this.init();
        //添加这些组件到窗口中
        this.addComponent();
        //设置这些组件在窗口中的位置
        this.setPosition();
        //添加按钮监听事件
        this.addListen();
    }

    private void addListen() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFruit();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFruit();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFruit();
            }
        });
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryId();
            }
        });
    }
    protected abstract void addFruit();
    protected abstract void updateFruit();
    protected abstract void deleteFruit();
    protected abstract void queryFruit();
    protected abstract void queryId();
    private void setPosition() {
        //取消默认布局
        this.setLayout(null);
        tabelLabel.setBounds(265,20,79,25);
        scrollPane.setBounds(50,50,500,200);
        idLabel.setBounds(50,250,70,25);
        nameLabel.setBounds(150,250,70,25);
        priceLabel.setBounds(250,250,70,25);
        unitLabel.setBounds(350,250,70,25);
        addIdText.setBounds(50,280,80,25);
        addNameText.setBounds(150,280,80,25);
        addPriceText.setBounds(250,280,80,25);
        addUnitText.setBounds(350,280,80,25);
        updateIdText.setBounds(50,310,80,25);
        updateNameText.setBounds(150,310,80,25);
        updatePriceText.setBounds(250,310,80,25);
        updateUnitText.setBounds(350,310,80,25);
        deleteIdText.setBounds(50,340,80,25);
        queryIdText.setBounds(50,370,80,25);
        addButton.setBounds(460,280,90,25);
        updateButton.setBounds(460,310,90,25);
        deleteButton.setBounds(460,340,90,25);
        queryButton.setBounds(460,370,90,25);
    }
    private void addComponent() {
        //反射出该字段的类型是数据
        Field[] fidlds = AbstractMainDialog.class.getDeclaredFields();
        for(int i = 0 ; i < fidlds.length ; i ++){
            try{
                Component component = (Component)fidlds[i].get(this);
                if(!(component instanceof JTable)){
                    this.add(component);
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }
    void init(){
        this.setTitle("超市管理");
        this.setSize(600,450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        GUITool.setTitleImage(this,"F:\\wintervacation\\image\\title.png");
    }
}
