package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;


public class PaintCanvas extends JComponent {
    private ArrayList<Rectangle> rectangles = new ArrayList<>();

    int x, y, width, height;

    public void drawRectangle(int x, int y, int width, int height) {
        rectangles.add(new Rectangle(x, y, width, height));
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;

        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here
        for (Rectangle rec: rectangles) {
            graphics2d.setColor(Color.GREEN);
            graphics2d.fillRect(rec.x, rec.y, rec.width, rec.height);
        }
    }
}
