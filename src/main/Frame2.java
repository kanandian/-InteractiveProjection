package main;

import javax.swing.*;


public class  Frame2
{
    public Frame2(){
        //加载图片
        ImageIcon icon=new ImageIcon("images/yezi.jpeg");

        JLabel label=new JLabel(icon);

        //设置label的大小
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        System.out.println(icon.getIconWidth()+" "+icon.getIconHeight());

        JFrame frame=new JFrame();

        //获取窗口的第二层，将label放入
        frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));

        //获取frame的顶层容器,并设置为透明
        JPanel j=(JPanel)frame.getContentPane();
        j.setOpaque(false);

        JPanel panel=new JPanel();

        panel.setOpaque(false);

        frame.add(panel);
        frame.add(panel);
        frame.setSize(icon.getIconWidth(),icon.getIconHeight());
        frame.setVisible(true);




    }
    public static void main(String[] args)
    {
        new Frame2();
    }
}