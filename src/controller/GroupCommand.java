package controller;

import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class GroupCommand {
    private PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public GroupCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void group() {
        shapes.group();
        paintCanvas.repaint();
    }
}