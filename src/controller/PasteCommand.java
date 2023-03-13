package controller;

import view.ICommand;
import view.IShape;
import view.gui.Clipboard;
import view.gui.PaintCanvas;
import model.*;
import view.gui.Shape;

import java.awt.*;
import java.util.ArrayList;

public class PasteCommand implements ICommand {
    private final PaintCanvas paintCanvas;
    Clipboard clipboard = Clipboard.getInstance();
    public PasteCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void execute() {
        paintCanvas.copyList(clipboard.getShapes());



    }
}
