package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.gui.PaintCanvas;
import controller.Point;

public class ClickHandler extends MouseAdapter {

    Point startPoint;
    Point endPoint;
    PaintCanvas paintCanvas;

    public ClickHandler(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());

    }

    public void mouseReleased(MouseEvent e) {
        endPoint = new Point(e.getX(), e.getY());

        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        //later on we will change this to be a more generalize create shape command. There we will have to pass through a shape and a class method. For now we will simply work with rec
        paintCanvas.drawRectangle(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y), width, height);
    }
}


