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
        System.out.println("here");
        shapes.group();
        paintCanvas.repaint();
    }
}
