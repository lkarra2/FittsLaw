package fittsmain;

import circledata.CaptureData;
import circledata.CircleData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/*
    FittsPanel.java is a class that defines the entire layout and flow of the experiment on Fitt's Law.
    It consisits of the following functions:
    FittsPanel() --> Starts the experiemnt, draws the first circle and calls mouseAction() function
    mouseAction() --> Checks if click occurs inside circle, if so, draws the next circle
    setRadii(caseNum) --> Selects the case for the next pair of circles
    drawCircle(x,y,w,h) --> Draws the next circle
 */

public class FittsPanel extends JPanel {

    private int[] circleRadius = {50, 350, 100};
    private int[] targetRadius = {25, 100};
    private Shape circle;
    private Dimension dim = new Dimension(1000, 1000);
    private boolean firstClick = true;
    private int i = 0;
    private int count = -1;
    CaptureData captureData;
    StopWatch watch = new StopWatch();
    long elapsedTime;
    ArrayList<CaptureData> dataArray = new ArrayList<>();
    int circleRadiusValue;
    int targetRadiusValue;
    int[] caseValues = {0, 1, 2, 3, 4, 5};
    HashSet<Integer> cases = new HashSet<Integer>();
    Random obj = new Random();
    private int count0 = 0;
    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private int count4 = 0;
    private int count5 = 0;
    private boolean set = false;


    public FittsPanel() {
        JOptionPane.showMessageDialog(null, "Click inside the Circle!", "Start", JOptionPane.INFORMATION_MESSAGE);
        drawCircle(300, 200, 300, 300);
        mouseAction();
    }

    private void mouseAction() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                //check if mouse is clicked within shape
                if (circle.contains(me.getPoint())) {
                    int X;
                    int Y;
                    ArrayList<CircleData> cPoints;
                    count++;
                    if (firstClick) {
                        set = setRadii(caseValues[obj.nextInt(caseValues.length)]);
                        while (set == false) {
                            set = setRadii(caseValues[obj.nextInt(caseValues.length)]);
                        }
                        watch.start();
                        GetCircle cir = new GetCircle(24, 400, 400, circleRadius[circleRadiusValue]);
                        cPoints = cir.getCirclePoints();
                        X = cPoints.get(i).getX();
                        Y = cPoints.get(i).getY();
                        drawCircle(X, Y, targetRadius[targetRadiusValue], targetRadius[targetRadiusValue]);
                        captureData = new CaptureData();
                        firstClick = false;
                    } else {
                        elapsedTime = watch.getElapsedTime();
                        watch.stop();
                        GetCircle cir = new GetCircle(24, 400, 400, circleRadius[circleRadiusValue]);
                        cPoints = cir.getCirclePoints();
                        X = cPoints.get(i + 12).getX();
                        Y = cPoints.get(i + 12).getY();
                        System.out.println("Elapsed = " + elapsedTime + "millis");
                        captureData.setElapsedTime(elapsedTime);
                        captureData.setCircleRadius(circleRadius[circleRadiusValue]);
                        captureData.setTargetRadius(targetRadius[targetRadiusValue]);
                        firstClick = true;
                        drawCircle(X, Y, targetRadius[targetRadiusValue], targetRadius[targetRadiusValue]);
                        i++;
                        dataArray.add(captureData);
                    }
                    if (count == 24) {
                        JOptionPane.showMessageDialog(null, "Done!", "Done", JOptionPane.INFORMATION_MESSAGE);
                        try {
                            writeToFile(dataArray);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        });

    }

    private boolean setRadii(int caseNum) {
        set = true;
        System.out.println("XXXXXXXXXX"+caseNum);
        switch (caseNum) {
            case 0: if(count0 < 4 ) {
                        circleRadiusValue = 0;
                        targetRadiusValue = 0;
                        count0++;
                        return true;
                    } else
                        return false;
            case 1: if(count1 < 4 ) {
                        circleRadiusValue = 0;
                        targetRadiusValue = 1;
                        count1++;
                        return true;
                    } else
                        return false;
            case 2: if(count2 < 4 ) {
                        circleRadiusValue = 1;
                        targetRadiusValue = 0;
                        count2++;
                        return true;
                    } else
                        return false;
            case 3: if(count3 < 4 ) {
                        circleRadiusValue = 1;
                        targetRadiusValue = 1;
                        count3++;
                        return true;
                    } else
                        return false;
            case 4: if(count4 < 4 ) {
                        circleRadiusValue = 2;
                        targetRadiusValue = 0;
                        count4++;
                        return true;
                    } else
                        return false;
            case 5: if(count5 < 4 ) {
                        circleRadiusValue = 2;
                        targetRadiusValue = 1;
                        count5++;
                        return true;
                    } else
                        return false;
        }
        return false;
    }

    private void drawCircle(int x, int y, int w, int h) {
        circle = new Ellipse2D.Double(x, y, w, h);
        System.out.println("X = "+x+" Y = "+y+" Target Diameter = "+w);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setColor(Color.black);
        g2d.fill(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }

    public void writeToFile(ArrayList<CaptureData> data) throws IOException {
        File fileName = new File("./data.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        for (CaptureData line:data) {
            writer.append(Long.toString(line.getElapsedTime()));
            writer.append(",");
            writer.append(Integer.toString(line.getCircleRadius()));
            writer.append(",");
            writer.append(Integer.toString(line.getTargetRadius()));
            writer.append("\n");
        }

        writer.close();
    }
}