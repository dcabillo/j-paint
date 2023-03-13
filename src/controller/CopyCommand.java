package controller;
import view.ICommand;
import view.IShape;
import view.gui.PaintCanvas;
import view.gui.Clipboard;
import view.gui.ShapeCollection;

import java.util.ArrayList;

public class CopyCommand implements ICommand {
    ShapeCollection shapes = ShapeCollection.getInstance();
    Clipboard clipboard = Clipboard.getInstance();

    ArrayList<IShape> clip = new ArrayList<>();

    public CopyCommand() {
    }

    public void execute() {
        clip = shapes.copy();
        clipboard.clear();
        for (IShape shape:clip) {
            clipboard.addShape(shape);
        }
    }

}
