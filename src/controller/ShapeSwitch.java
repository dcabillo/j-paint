package controller;

import model.persistence.ApplicationState;
import view.IDrawShape;
import view.IShape;
import view.gui.Ellipse;
import view.gui.Rectangle;
import view.gui.Triangle;
import model.ShapeType;


public class ShapeSwitch {
    ShapeType shape;
    public ShapeSwitch(ApplicationState applicationState){
        this.shape = applicationState.getActiveShapeType();

    }

    public IDrawShape getShape(int sx, int sy, int width, int height) {
        switch (this.shape) {
            case TRIANGLE:
                IDrawShape tri = new Triangle(sx, sy, width, height);
                return tri;
            case ELLIPSE:
                IDrawShape ellipse = new Ellipse(sx, sy, width, height);
                return ellipse;
            default:
                IDrawShape rec = new Rectangle(sx, sy, width, height);
                return rec;
        }
    }
}
