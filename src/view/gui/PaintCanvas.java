package view.gui;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;



public class PaintCanvas extends JComponent {
    ShapeCollection shapes = ShapeCollection.getInstance();

    public void drawRectangle(int x, int y, int width, int height) {
        Rectangle rec = new Rectangle(x, y, width, height);
        shapes.addRectangle(rec);
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;

        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here
        for (Rectangle rec: shapes.getRectangles()) {
            graphics2d.setColor(Color.GREEN);
            graphics2d.fillRect(rec.x, rec.y, rec.width, rec.height);
        }
    }
}
