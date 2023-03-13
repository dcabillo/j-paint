package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.ClickHandler;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState, paintCanvas);
        ClickHandler clickHandler = new ClickHandler(paintCanvas, appState);
        paintCanvas.addMouseListener(clickHandler);
        paintCanvas.addMouseMotionListener(clickHandler);

        controller.setup();
    }
}
