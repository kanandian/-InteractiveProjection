package main;

public class Main {
    public static void main(String[] args) {
        InterationFrame interationFrame = new InterationFrame();

        for (int i=0;i<100;i++) {
            Leaf leaf = new Leaf();
            leaf.setPosition_x((int) (Math.random()*interationFrame.getWidth()+1));
            leaf.setPosition_y((int) (Math.random()*interationFrame.getHeight()+1));
//            leaf.setPosition_x(200);
//            leaf.setPosition_y(200);
            interationFrame.addLeaf(leaf);
        }
    }
}
