package main;

/**
 * 设置窗体背景图片
 * @author gao
 */


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundDemo extends JFrame{
    private Image image;
    private static final long serialVersionUID=-1588458291133087637L;
    public BackgroundDemo(){
        this.setTitle("设置窗体的背景颜色");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0 , 0, 400,300 );

        JPanel contentPane=new JPanel(){
            @Override
            public void paint(Graphics g) {
                ImageIcon icon=new ImageIcon("images/yezi.jpeg");
                image=icon.getImage();
                g.drawImage(image, 0,0,null);
                // TODO Auto-generated method stub

            }
        };
        this.add(contentPane);
        this.setVisible(true);
    }


    public static void main(String[]args){
        BackgroundDemo example=new BackgroundDemo();

    }
}
