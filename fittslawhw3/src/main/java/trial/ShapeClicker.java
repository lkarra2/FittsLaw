package trial;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShapeClicker {

    public ShapeClicker() {
        JFrame frame = new JFrame();
        frame.setTitle("Shape Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        initComponents(frame);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //create frame and components on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShapeClicker();
            }
        });
    }

    private void initComponents(JFrame frame) {
        frame.add(new ShapePanel());
    }
}

//custom panel
class ShapePanel extends JPanel {

    private Shape circle = new Ellipse2D.Double(260, 100, 100, 100);
    private Dimension dim = new Dimension(450, 300);

    public ShapePanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                if (circle.contains(me.getPoint())) {//check if mouse is clicked within shape

                    //we can either just print out the object class name
                    System.out.println("Clicked a "+circle.getClass().getName());

                    if (circle instanceof Ellipse2D) {
                        System.out.println("Clicked a circle");
                    }

                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }
}