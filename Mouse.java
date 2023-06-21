import java.awt.*;

public class Mouse {
    public static void moveup(int x, int y) {
        Robot r;
        try {
            r = new Robot();
            Point p = MouseInfo.getPointerInfo().getLocation();
            int xi = p.x;
            int yi = p.y;
            for (int i = 0; i < 500; i++) {
                r.mouseMove(xi + (x * i / 500), yi + (y * i / 500));
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        moveup(100, 100);
    }
}