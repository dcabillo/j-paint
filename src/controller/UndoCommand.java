package controller;

import view.ICommand;
import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class UndoCommand implements ICommand {

    private final PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public UndoCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        // shifting the index on the stack and repainting
        shapes.undoShape();
        paintCanvas.repaint();
    }
}
