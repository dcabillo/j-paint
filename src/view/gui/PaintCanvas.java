package view.gui;

import view.IShape;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;



public class PaintCanvas extends JComponent {
    ShapeCollection shapes = ShapeCollection.getInstance();

    public void drawRectangle(int x, int y, int width, int height) {
        Ellipse ellipse = new Ellipse(x, y, width, height);
        IShape shape = new Shape(ellipse);
        shapes.addShape(shape);
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;

        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here
        for (IShape shape: shapes.getShapes()) {
            shape.draw(graphics2d);
        }
    }
}
