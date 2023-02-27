package controller;

import view.IDrawShape;
import model.*;
import view.gui.Ellipse;
import view.gui.Rectangle;
import view.gui.Shape;
import view.gui.Triangle;

public class ShapeFactory {
    IDrawShape shape;
    public ShapeFactory(ShapeType shapeType, int sx, int sy, int width, int height) {
        if (shapeType == ShapeType.RECTANGLE) {
            this.shape = new Rectangle(sx, sy, width, height);
        }
        if (shapeType == ShapeType.TRIANGLE) {
            this.shape = new Triangle(sx, sy, width, height);
        }
        if (shapeType == ShapeType.ELLIPSE) {
            this.shape = new Ellipse(sx, sy, width, height);
        }

    }

    public IDrawShape getShape() {
        return this.shape;
    }
}
