package controller;

import view.ICommand;
import view.gui.PaintCanvas;

public class NullCommand implements ICommand {
    private PaintCanvas paintCanvas;

    public NullCommand(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }
    public void execute(){}
}
