package controller;
import view.IShape;
import view.gui.PaintCanvas;
import view.gui.Clipboard;
import view.gui.ShapeCollection;

import java.util.ArrayList;

public class CopyCommand {
    ShapeCollection shapes = ShapeCollection.getInstance();
    Clipboard clipboard = Clipboard.getInstance();

    ArrayList<IShape> clip = new ArrayList<>();

    public CopyCommand() {
    }

    public void copy() {
        clip = shapes.copy();
        clipboard.clear();
        for (IShape shape:clip) {
            clipboard.addShape(shape);
        }
    }

}
