package fittsmain;

import javax.swing.*;
import java.awt.*;

/*
    FittsMain.java is a class that creates and calls initComponents(frame),
    a function which initialises and starts the experiment.
 */


public class FittsMain extends JPanel {

    static JFrame frame;

    public FittsMain() {
        frame = new JFrame();
        frame.setTitle("Fitt's Law Experiment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000, 1000));
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setMaximumSize(new Dimension(1000,1000));
        initComponents(frame);
        frame.pack();
        frame.setBackground(Color.white);
        frame.setVisible(true);

    }

    private void initComponents(JFrame frame) {
        frame.add(new FittsPanel());
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FittsMain();
            }
        });
    }

}