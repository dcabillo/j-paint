package controller;

import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class UngroupCommand {
    private PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public UngroupCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void ungroup() {
        shapes.unGroup();
        paintCanvas.repaint();
    }
}
