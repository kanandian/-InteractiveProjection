package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterationFrame extends JFrame {

    private int width = 1920, height=1080;

//    private Image image = GameUtil.getImage("images/yezi.jpeg");
    private ImageIcon imageIcon = new ImageIcon("images/yezi.png");

    private ArrayList<Leaf> leaves = new ArrayList<Leaf>();
    private ArrayList<Leaf> removeLeaves = new ArrayList<Leaf>();

    public InterationFrame() {
        setVisible(true);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(200, 160, Image.SCALE_DEFAULT));

        addWindowListener(new WindowAdapter() {
            // 单击右键选择“source”中的“override/implement
            // methods”，frame里面勾选“windowClosed”点击“OK”
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

//        addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                sweep(e.getX(), e.getY());
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                sweep(e.getX(), e.getY());
            }
        });

        new PaintThread().start();
        new MoveThread().start();
        new AddLeafThread().start();
    }

    public void sweep(int x, int y) {
        double a, b;
        boolean fa = false, fb = false;
        for (int i=0;i<leaves.size();i++) {
            Leaf leaf = leaves.get(i);
            if (getDistance(leaf, x, y) <= 300) {
                b = Math.abs(getDistanceY(leaf, y) / getDistanceX(leaf, x));

                if (getDistanceX(leaf, x) < 0) {
                    fa = true;
                }
                if (getDistanceY(leaf, y) < 0) {
                    fb = true;
                }

                a = leaf.getSpeed()/Math.sqrt(1+b*b);
                b *= a;

                if (fa) {
                    a *= -1;
                }
                if (fb) {
                    b *= -1;
                }

                leaf.setDirection_x(a);
                leaf.setDirection_y(b);
            }
        }
    }

    public double getDistanceX(Leaf leaf, int x) {
        return leaf.getPosition_x()+imageIcon.getIconWidth()/2-x;
    }

    public double getDistanceY(Leaf leaf, int y) {
        return leaf.getPosition_y()+imageIcon.getIconHeight()/2-y;
    }

    public double getDistance(Leaf leaf, int x, int y) {
//        double x1 = leaf.getPosition_x()+imageIcon.getIconWidth()/2;
//        double y1 = leaf.getPosition_y()+imageIcon.getIconHeight()/2;
        return Math.sqrt(Math.pow(getDistanceX(leaf, x), 2)+Math.pow(getDistanceY(leaf, y), 2));
    }

    public boolean isOutOfRange(Leaf leaf) {
        Dimension dimension = getSize();
        if (leaf.getPosition_y()+imageIcon.getIconHeight() < 0 || leaf.getPosition_y() > dimension.getHeight() || leaf.getPosition_x()+imageIcon.getIconWidth()<0 || leaf.getPosition_x() > dimension.getWidth()) {
            return true;
        }
        return false;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    //    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        for (int i=0;i<this.leaves.size();i++) {
//            g.drawImage(GameUtil.getImage("images/yezi.jpeg"), leaves.get(i).getPosition_x(), leaves.get(i).getPosition_y(), null);
//        }
//    }


    class PaintThread extends Thread {

        public void run() {
            while (true) {
                updateLeaves();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void updateLeaves() {
            synchronized (leaves) {
                for (int i = 0; i < leaves.size(); i++) {
                    Leaf leaf = leaves.get(i);
                    JLabel label = leaf.getLabel();

                    label.setLocation((int) leaf.getPosition_x(), (int) leaf.getPosition_y());
                }
            }
                repaint();

        }

    }

    class MoveThread extends Thread {
        public void run() {
            while (true){
                removeLeaves.clear();
                synchronized (leaves) {
                    for (int i = 0; i < leaves.size(); i++) {
                        Leaf leaf = leaves.get(i);
                        if (isOutOfRange(leaf)) {
//                        leaves.remove(leaf);
//                        i--;
                            removeLeaves.add(leaf);
                        } else {
                            if (leaf.getDirection_x() == -1 && leaf.getDirection_y() == -1) {
                                leaf.setPosition_y(leaf.getPosition_y()+3);
                            } else {
                                leaf.setPosition_x(leaf.getPosition_x()+leaf.getDirection_x());
                                leaf.setPosition_y(leaf.getPosition_y()+leaf.getDirection_y());
                            }
                        }
                    }
                    leaves.removeAll(removeLeaves);
                }

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class AddLeafThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Leaf leaf = new Leaf();
                leaf.setPosition_x((int) (Math.random()*getWidth()+1));
                leaf.setPosition_y(-1*imageIcon.getIconHeight()+5);
                addLeaf(leaf);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

//    public Image getImage() {
//        return image;
//    }

    public void addLeaf(Leaf leaf) {
        JLabel label = new JLabel();
        label.setIcon(imageIcon);
        label.setBounds((int) leaf.getPosition_x(), (int) leaf.getPosition_y(), imageIcon.getIconWidth(), imageIcon.getIconHeight());
        leaf.setLabel(label);
        synchronized (leaves) {
            this.leaves.add(leaf);
        }
        this.add(label);
    }

}
