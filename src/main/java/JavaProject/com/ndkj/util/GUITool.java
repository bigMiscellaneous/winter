package JavaProject.com.ndkj.util;

import java.awt.*;

public class GUITool {

    //给window窗口设置imagePath这张图片
    public static void setTitleImage(Window window,String imagePath){
        Toolkit kit = Toolkit.getDefaultToolkit();
        //给窗口设置标题图片
        window.setIconImage(kit.createImage(imagePath));
    }
}
