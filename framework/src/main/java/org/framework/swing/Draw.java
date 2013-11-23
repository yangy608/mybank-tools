/** 
 * 一个公式，改变各个参数值，你就可以拥有各种各样的抽象图画，很神奇 
 * 使用一个按钮控制绘制 
 */  
package org.framework.swing;  
  
import java.awt.Color;  
import java.awt.FlowLayout;  
import java.awt.Graphics;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JButton;  
import javax.swing.JFrame;  
  
public class Draw extends JFrame implements ActionListener {  
      
    //将画布对象设置为类的属性，可以在类的方法中使用  
    private Graphics g;  
      
    //入口函数  
    public static void main(String[] args) {  
        Draw d = new Draw();  
        d.init();  
          
    }  
      
    // 初始化画板  
    public void init() {  
        this.setTitle("神奇的函数");  
        this.setSize(700, 700);  
        this.setDefaultCloseOperation(3);  
        this.setLayout(new FlowLayout());  
        this.setLocationRelativeTo(null);  
        this.getContentPane().setBackground(Color.black);  
        this.setVisible(true);  
          
        // 获取画布对象  
        g = this.getGraphics();  
  
        // 添加一个控制按钮  
        JButton bu = new JButton("画图");  
        bu.setActionCommand("draw");  
        this.add(bu);  
        bu.addActionListener(this);  
    }  
       
    //重写ActionLitener中的方法，在此实现绘制的方法  
    public void actionPerformed(ActionEvent e) {  
          
        //初始化x和y  
        double x = 0, y = 0;  
          
        //给公式的常量赋值，改变每个值可以得到不同的图像  
        double a =-1.7, b = -2.5, c = -2, d = -2;  
          
        //使用循环计算出每次迭代的值，并完成绘制  
        for (int i = 0; i < 100000; i++) {  
              
            //调用java中Math中的方法,计算函数值，计算出当前的x和y的值，下一次循环时用当前的x,y的值计算下一此的x和y的值，依次下去  
            x = d * Math.sin(a * x) - Math.sin(b * y);  
            y = c * Math.cos(a * x) + Math.cos(b * y);  
              
            //由于画布坐标的特点，所以作如下处理（左上角为原点，竖直向下为Ｙ轴，计算的值太小所以*100，+330是为了将隐藏的点平移到画布上来）  
            int m = (int) ((d * Math.sin(a * x) - Math.sin(b * y)) * 100+330);  
            int n = (int) ((c * Math.cos(a * x) + Math.cos(b * y)) * 100+350);  
              
            //给每个点上颜色，并绘制  
            g.setColor(new Color(250,i%255,i%155));  
                g.drawLine(m, n, m, n);  
  
        }  
    }  
}  
