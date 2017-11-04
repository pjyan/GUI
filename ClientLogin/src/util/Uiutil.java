/*
 样式类
*/

package util;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 *
 * @author PeiJia Yan
 */
public class Uiutil {
    
    private Uiutil(){}
    
    //修改咖啡图标
    public static void setFrameImage(JFrame jf){
        //获取图标 
        Toolkit tk = Toolkit.getDefaultToolkit();
         Image i = tk.getImage("src\\resource\\user.jpg");
         //窗体设置图片
         jf.setIconImage(i);
  
    }
   //设置居中
    public static void setFrameCenter(JFrame jf){
        //a.获取屏幕的宽高
        //b.获取屏幕的宽高
        //c.（屏幕的宽高-屏幕的宽高）/2 作为新坐标
        
        //屏幕宽高
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        double width1 = d.getWidth();
        double height1 = d.getHeight();
        
        //窗体宽高
        int width2 = jf.getWidth();
        int height2 = jf.getHeight();
        
        //设置新坐标
        jf.setLocation((int)((width1-width2)/2), (int)((height1-height2)/2));
        
    }
}
