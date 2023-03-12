package controller;

import view.IShape;
import view.gui.Clipboard;
import view.gui.PaintCanvas;
import model.*;
import view.gui.Shape;

import java.awt.*;
import java.util.ArrayList;

public class PasteCommand {
    private final PaintCanvas paintCanvas;
    Clipboard clipboard = Clipboard.getInstance();
    public PasteCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void paste() {
        paintCanvas.copyList(clipboard.getShapes());



    }
}
