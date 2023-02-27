package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.persistence.ApplicationState;
import view.IDrawShape;
import view.IShape;
import view.gui.PaintCanvas;
import model.*;
import view.gui.ShapeCollection;

public class ClickHandler extends MouseAdapter {

    Point startPoint;
    Point endPoint;
    PaintCanvas paintCanvas;
    ApplicationState appState;

    public ClickHandler(PaintCanvas paintCanvas, ApplicationState applicationState) {

        this.paintCanvas = paintCanvas;
        this.appState = applicationState;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());

    }
    public  void draw(int start_x, int start_y, int end_x, int end_y){
        int width = Math.abs(end_x - start_x);
        int height = Math.abs(end_y - start_y);

        ShapeSwitch swich = new ShapeSwitch(appState);

        IDrawShape shape = swich.getShape(Math.min(start_x, end_x), Math.min(start_y, end_y), width, height);
        Color primaryColor = swich.getPrimary();
        Color secondaryColor = swich.getSecondary();
        String shading = swich.getShading();
        paintCanvas.drawShape(shape, primaryColor, secondaryColor, shading);
    }



    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());

        if (appState.getActiveMouseMode() == MouseMode.DRAW){
            draw(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
        else if (appState.getActiveMouseMode() == MouseMode.SELECT){
            paintCanvas.selectShapes(-1, -1, -1,-1);
            paintCanvas.selectShapes(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y), Math.max(startPoint.x, endPoint.x), Math.max(startPoint.y, endPoint.y));
        }
        else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
            ArrayList<Integer> selected = paintCanvas.getSelectedList();
            int dx = endPoint.x - startPoint.x;
            int dy = endPoint.y - startPoint.y;
            for (Integer idx: selected) {
                IShape oldShape = paintCanvas.getShape(idx);
                Color primaryColor = oldShape.getPrimaryColor();
                Color secondaryColor = oldShape.getSecondaryColor();
                String shading = oldShape.getShadingType();
                ShapeType type = oldShape.getShape();
                int[] coordinates = oldShape.getCoord();
                int width = coordinates[2] - coordinates[0];
                int height = coordinates[3] - coordinates[1];
                int sx = coordinates[0] + dx;
                int sy = coordinates[1] + dy;
                ShapeFactory shape = new ShapeFactory(type, sx, sy, width, height);
                paintCanvas.replaceShape(idx, shape.getShape(), primaryColor, secondaryColor, shading);
            }
            paintCanvas.repaint();

        }

    }

}


