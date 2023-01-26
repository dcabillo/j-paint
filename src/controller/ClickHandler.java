package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.gui.PaintCanvas;

public class ClickHandler extends MouseAdapter {

    Point startPoint;
    Point endPoint;
    PaintCanvas paintCanvas;

    public ClickHandler(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point();
        startPoint.x = e.getX();
        startPoint.y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        endPoint = new Point();
        endPoint.x = e.getX();
        endPoint.y = e.getY();

        int width = endPoint.x - startPoint.x;
        int height = endPoint.y - startPoint.y;

        paintCanvas.drawRectangle(startPoint.x, startPoint.y, width, height);
    }
}


class Point {
    public int x;
    public int y;
}
