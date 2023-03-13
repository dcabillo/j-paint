package controller;

import view.ICommand;
import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class GroupCommand implements ICommand {
    private PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public GroupCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        shapes.group();
        paintCanvas.repaint();
    }
}
