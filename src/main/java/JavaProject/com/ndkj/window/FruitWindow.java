package JavaProject.com.ndkj.window;

import JavaProject.com.ndkj.dao.FruitDao;
import JavaProject.com.ndkj.dialog.FruitDialog;

import java.sql.SQLOutput;

public class FruitWindow extends AbstractMainFrame {

    @Override
    public void doSomethingByButton(){
       new FruitDialog(this,true).setVisible(true);
    }

    public static void main(String[] args) {
        new FruitWindow().setVisible(true);
    }
}
