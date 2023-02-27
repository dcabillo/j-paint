package controller;
import view.IShape;
import view.gui.PaintCanvas;
import view.gui.Clipboard;

import java.util.ArrayList;

public class CopyCommand {
    private final PaintCanvas paintCanvas;
    Clipboard clipboard = Clipboard.getInstance();
    public CopyCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void copy() {
        ArrayList<Integer> selected = paintCanvas.getSelectedList();
        for (Integer idx: selected) {
            IShape shape = paintCanvas.getShape(idx);
            clipboard.addShape(shape);
        }

    }
}
