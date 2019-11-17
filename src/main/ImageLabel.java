package main;

import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {

    private ImageIcon imageIcon;

    public ImageLabel() {
        this(new ImageIcon("images/yezi.jpeg"));
    }

    public ImageLabel(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(imageIcon.getImage(), 0, 0, getWidth(),getHeight(),
                imageIcon.getImageObserver());
    }


}
