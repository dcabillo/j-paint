package controller;

import view.ICommand;
import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class DeleteCommand implements ICommand {
    private final PaintCanvas paintCanvas;
    ShapeCollection shapes = ShapeCollection.getInstance();
    public DeleteCommand(PaintCanvas paintCanvas) {this.paintCanvas = paintCanvas;}

    public void execute() {
        shapes.delete();
        paintCanvas.repaint();
    }
}
