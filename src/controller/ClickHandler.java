package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.persistence.ApplicationState;
import view.IDrawShape;
import view.gui.PaintCanvas;
import model.ShapeType;
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

    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());

        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        ShapeSwitch swich = new ShapeSwitch(this.appState);

        IDrawShape shape = swich.getShape(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y), width, height);
        Color primaryColor = swich.getPrimary();
        Color secondaryColor = swich.getSecondary();
        String shading = swich.getShading();
        paintCanvas.drawShape(shape, primaryColor, secondaryColor, shading);
    }
}


