package controller;

import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class DeleteCommand {
    private final PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public DeleteCommand(PaintCanvas paintCanvas) {this.paintCanvas = paintCanvas;}

    public void delete() {
        shapes.delete();
        paintCanvas.repaint();
    }
}
