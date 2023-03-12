package view.gui;

import view.IDrawShape;
import view.IShape;
import model.*;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


public class PaintCanvas extends JComponent {
    ShapeCollection shapes = ShapeCollection.getInstance();

    public void drawShape(IDrawShape shape, Color primaryColor, Color secondaryColor, String shading) {
        IShape shapeSelection = new Shape(shape, primaryColor, secondaryColor, shading);
        shapes.addShape(shapeSelection);
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;

        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here
        for (IShape shape: shapes.getShapes()) {
            graphics2d.setStroke(new BasicStroke(2.0f));
            shape.draw(graphics2d);
        }
    }

    public void selectShapes(int start_x, int start_y, int end_x, int end_y) {
        shapes.setSelectedShapes(start_x, start_y, end_x, end_y);
        repaint();
    }



    public void moveShape(int dx, int dy) {
        shapes.moveShape(dx, dy);
    }

    public void copyList(ArrayList<IShape> copyList) {
        shapes.paste(copyList);
        repaint();
    }


}
