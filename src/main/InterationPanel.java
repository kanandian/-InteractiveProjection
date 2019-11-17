package main;

import javax.swing.*;
import java.awt.*;

public class InterationPanel extends JPanel {

    Image image = null;

    public InterationPanel() {
        image = GameUtil.getImage("images/yezi.jpeg");

    }


//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//        g.drawImage(image, 100, 100, null);
//    }

        @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 100, 100, null);
    }



}
