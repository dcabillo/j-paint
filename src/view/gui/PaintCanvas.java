package view.gui;

import view.IDrawShape;
import view.IShape;
import model.*;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;



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
            shape.draw(graphics2d);
        }
    }

    public void selectShapes(int start_x, int start_y, int end_x, int end_y) {
        shapes.setSelectedShapes(start_x, start_y, end_x, end_y);
    }

    public ArrayList<Integer> getSelectedList() {
        ArrayList<Integer> selected = shapes.findSelected();
        return selected;
    }
    public ArrayList<ShapeType> findShapes(ArrayList<Integer> selected) {
        ArrayList<ShapeType> shapeReplace = new ArrayList<>();
        for (Integer idx: selected) {
            shapeReplace.add(shapes.getShapeIndex(idx));
        }
        return shapeReplace;
    }

    public ArrayList<int[]> getCoords(ArrayList<Integer> selected){
        ArrayList<int[]> coords = new ArrayList<>();
        for (Integer idx: selected) {
            coords.add(shapes.getCoorIndex(idx));
        }
        return coords;
    }


}
