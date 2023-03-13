package controller;

import view.ICommand;
import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class RedoCommand implements ICommand {
    private PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public RedoCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        // shifting the index on the stack and repainting
        shapes.redoShape();
        paintCanvas.repaint();
    }
}
