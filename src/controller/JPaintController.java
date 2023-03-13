package controller;

import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;
import view.gui.*;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final PaintCanvas paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, PaintCanvas paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        CommandFactory commandFactory = new CommandFactory();
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> commandFactory.createCommand(EventName.UNDO, paintCanvas).execute());
        uiModule.addEvent(EventName.REDO, () -> commandFactory.createCommand(EventName.REDO, paintCanvas).execute());
        uiModule.addEvent(EventName.COPY, () -> commandFactory.createCommand(EventName.COPY, paintCanvas).execute());
        uiModule.addEvent(EventName.PASTE, () -> commandFactory.createCommand(EventName.PASTE, paintCanvas).execute());
        uiModule.addEvent(EventName.DELETE, () -> commandFactory.createCommand(EventName.DELETE, paintCanvas).execute());
        uiModule.addEvent(EventName.GROUP, () -> commandFactory.createCommand(EventName.GROUP, paintCanvas).execute());
        uiModule.addEvent(EventName.UNGROUP, () -> commandFactory.createCommand(EventName.UNGROUP, paintCanvas).execute());
    }
}
