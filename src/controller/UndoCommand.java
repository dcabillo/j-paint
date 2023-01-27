package controller;

import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class UndoCommand {

    private final PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public UndoCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void undo() {
        shapes.removeRectangle();
        paintCanvas.repaint();
    }
}
