package controller;

import view.ICommand;
import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class UngroupCommand implements ICommand {
    private PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public UngroupCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        shapes.unGroup();
        paintCanvas.repaint();
    }
}
