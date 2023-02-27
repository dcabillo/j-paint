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
        // shifting the index on the stack and repainting
        shapes.undoShape();
        paintCanvas.repaint();
    }
}
