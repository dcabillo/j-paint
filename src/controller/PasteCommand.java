package controller;

import view.IShape;
import view.gui.Clipboard;
import view.gui.PaintCanvas;
import model.*;
import view.gui.Shape;

import java.awt.*;
import java.util.ArrayList;

public class PasteCommand {
    private final PaintCanvas paintCanvas;
    Clipboard clipboard = Clipboard.getInstance();
    public PasteCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void paste() {
        ArrayList<IShape> copyList = new ArrayList<>();

        for (IShape oldShape: clipboard.getShapes()){
            Color primaryColor = oldShape.getPrimaryColor();
            Color secondaryColor = oldShape.getSecondaryColor();
            String shading = oldShape.getShadingType();
            ShapeType type = oldShape.getShape();
            int[] coordinates = oldShape.getCoord();
            int width = coordinates[2] - coordinates[0];
            int height = coordinates[3] - coordinates[1];
            int sx = coordinates[0] + 30;
            int sy = coordinates[1] + 30;
            ShapeFactory shape = new ShapeFactory(type, sx, sy, width, height);
            IShape newShape = new Shape(shape.getShape(), primaryColor, secondaryColor, shading);
            copyList.add(newShape);
        }
        paintCanvas.copyList(copyList);



    }
}
