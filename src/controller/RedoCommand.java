package controller;

import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class RedoCommand {
    private PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public RedoCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void redo() {
        shapes.redoRectangle();
        paintCanvas.repaint();
    }
}
