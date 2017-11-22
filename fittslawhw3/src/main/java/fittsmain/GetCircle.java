package fittsmain;

import circledata.CircleData;

import javax.swing.*;
import java.util.ArrayList;

public class GetCircle extends JPanel {

    private int a, b, r;
    private int n;

    /**
     * @param n  the desired number of circles.
     */
    public GetCircle(int n, int centerX, int centerY, int radius) {
        super(true);
        this.n = n;
        a = centerX;
        b = centerY;
        r = radius;
    }

    public ArrayList<CircleData> getCirclePoints() {
        ArrayList<CircleData> circleData = new ArrayList<>();
        System.out.println("For the global center " + a + "," + b + " and radius " + r);
        for (int i = 0; i < n; i++) {
            CircleData circle = new CircleData();
            double t = 2 * Math.PI * i / n;
            int x = (int) Math.round(a + r * Math.cos(t));
            int y = (int) Math.round(b + r * Math.sin(t));
            circle.setX(x);
            circle.setY(y);
            System.out.println(i + "--x=" + x + " y" + y);
            circleData.add(circle);
        }
        return circleData;

    }
}
