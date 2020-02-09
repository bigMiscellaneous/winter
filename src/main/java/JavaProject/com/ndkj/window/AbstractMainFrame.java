package JavaProject.com.ndkj.window;

import JavaProject.com.ndkj.util.GUITool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMainFrame extends JFrame {

    JButton button = new JButton("进入系统");

    public AbstractMainFrame(){
        this.init();
        this.addComponent(); //添加水果欢迎图片和系统按钮
        addListen();
    }

    void init(){
        GUITool.setTitleImage(this,"F:\\wintervacation\\image\\title.png");
        this.setTitle("水果超市欢迎您!");
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        //关闭窗口的时候退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent(){
        ImageIcon imageIcon = new ImageIcon("F:\\wintervacation\\image\\FruitStore.jpg");
        JLabel jLabel = new JLabel(imageIcon);
        //包包含图片的jLbel加入到this窗口里面的北边
        this.add(jLabel, BorderLayout.NORTH);

        //null代表取消默认置顶布局，这样就可在后面setBound自定义位置
        JPanel panel = new JPanel(null);
        panel.add(button);

        button.setBounds(240,20,120,50);
        //窗口中添加panel即可，因为按钮在panel中
        this.add(panel);
    }

    //该方法抽象，给子类去定义具体做什么
    public abstract void doSomethingByButton();

    void addListen(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSomethingByButton();
            }
        });
    }
}
