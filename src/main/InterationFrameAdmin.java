package main;

public class InterationFrameAdmin {

    private static InterationFrame interationFrame = null;


    private InterationFrameAdmin() {

    }

    public static InterationFrame getInstance() {
        if (interationFrame == null) {
            synchronized (InterationFrame.class) {
                if (interationFrame == null) {
                    interationFrame = new InterationFrame();
                }
            }
        }

        return interationFrame;
    }


}
