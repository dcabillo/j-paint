package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.Timer;

import model.persistence.ApplicationState;
import view.IDrawShape;
import view.IShape;
import view.gui.PaintCanvas;
import model.*;
import view.gui.Shape;
import view.gui.ShapeCollection;
import controller.ShapeFactory;

public class ClickHandler extends MouseAdapter {

    Point startPoint;
    Point endPoint;
    PaintCanvas paintCanvas;
    ApplicationState appState;
    private Timer timer;
    private int delay = 3;

    private boolean isDrawing = false;

    public ClickHandler(PaintCanvas paintCanvas, ApplicationState applicationState) {

        this.paintCanvas = paintCanvas;
        this.appState = applicationState;
        this.timer = new Timer(delay, e -> handleMouseDragged());
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
        isDrawing =true;
        paintCanvas.pressed();

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

    public void mouseDragged(MouseEvent e) {
        if (appState.getActiveMouseMode() == MouseMode.DRAW ||  appState.getActiveMouseMode() == MouseMode.SELECT) {
            if (isDrawing) {
                endPoint = new Point(e.getX(), e.getY());
                timer.restart();
            }
        }

    }
    private void handleMouseDragged() {
        //IF there are any errors please comment out this
        timer.stop();
        ShapeSwitch swich = new ShapeSwitch(appState);
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);



        if (appState.getActiveMouseMode() == MouseMode.SELECT) {

            ShapeFactory shape = new ShapeFactory(ShapeType.RECTANGLE, Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y), width, height);
            Color primaryColor = Color.BLACK;
            Color secondaryColor = Color.BLACK;
            String shading = "OUTLINED";
            paintCanvas.dragging(shape.getShape(), primaryColor, secondaryColor, shading);
        }
        else {
            IDrawShape shape = swich.getShape(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y), width, height);
            Color primaryColor = swich.getPrimary();
            Color secondaryColor = swich.getSecondary();
            String shading = swich.getShading();
            paintCanvas.dragging(shape, primaryColor, secondaryColor, shading);
        }

        paintCanvas.repaint();
    }



    public void mouseReleased(MouseEvent e) {
        isDrawing =false;
        endPoint = new Point(e.getX(), e.getY());
        paintCanvas.released();

        if (appState.getActiveMouseMode() == MouseMode.DRAW){
            draw(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
        else if (appState.getActiveMouseMode() == MouseMode.SELECT){
            paintCanvas.selectShapes(-1, -1, -1,-1);
            paintCanvas.selectShapes(Math.min(startPoint.x, endPoint.x), Math.min(startPoint.y, endPoint.y), Math.max(startPoint.x, endPoint.x), Math.max(startPoint.y, endPoint.y));
        }
        else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
            int dx = endPoint.x - startPoint.x;
            int dy = endPoint.y - startPoint.y;
            paintCanvas.moveShape(dx, dy);
            paintCanvas.repaint();

        }

    }

}


