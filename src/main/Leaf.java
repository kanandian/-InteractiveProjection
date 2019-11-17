package main;

import javax.swing.*;
import java.awt.*;

public class Leaf extends JLabel {

    private double position_x, position_y;
    private double direction_x, direction_y;
    private JLabel label;
    private double speed;
//    private InterationFrame interationFrame = InterationFrameAdmin.getInstance();

//    private Image image = InterationFrameAdmin.getInstance().getImage();

    public Leaf() {
        this.direction_x = -1;
        this.direction_y = -1;
        this.speed = 3;
    }


//    public void paint() {
//        interationFrame.getGraphics().drawImage(GameUtil.getImage("images/yezi.jpeg"), position_x, position_y, null);
//        interationFrame.repaint();
//
//    }

    public double getPosition_x() {
        return position_x;
    }

    public void setPosition_x(double position_x) {
        this.position_x = position_x;
    }

    public double getPosition_y() {
        return position_y;
    }

    public void setPosition_y(double position_y) {
        this.position_y = position_y;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public double getDirection_x() {
        return direction_x;
    }

    public void setDirection_x(double direction_x) {
        this.direction_x = direction_x;
    }

    public double getDirection_y() {
        return direction_y;
    }

    public void setDirection_y(double direction_y) {
        this.direction_y = direction_y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
