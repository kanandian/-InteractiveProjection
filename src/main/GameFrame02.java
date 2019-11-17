package main;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame02 extends Frame {

    Image image = GameUtil.getImage("images/yezi.jpeg");

    public void launchFrame() {
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);

        new PaintThread().start();

        addWindowListener(new WindowAdapter() {
            // 单击右键选择“source”中的“override/implement
            // methods”，frame里面勾选“windowClosed”点击“OK”
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private double x = 100, y = 100;
    private boolean left;
    private boolean up;

    // 单击右键选择“source”中的“override/implement
    // methods”，window里面勾选“paint(graphic)”点击“OK”
    @Override
    public void paint(Graphics g) {

        g.drawImage(image, (int) x, (int) y, null);
        if (left) {
            x -= 3;
        } else {
            x += 3;
        }
        if (x > 500 - 130) {
            left = true;
        }
        if (x < 0) {
            left = false;
        }

        if (up) {
            y -= 5;
        } else {
            y += 5;
        }
        if (y > 500 - 130) {
            up = true;
        }
        if (y < 30) {
            up = false;
        }

    }

    class PaintThread extends Thread {

        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        GameFrame02 gf = new GameFrame02();
        gf.launchFrame();
    }

}