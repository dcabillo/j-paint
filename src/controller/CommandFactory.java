package controller;
import view.ICommand;
import view.EventName;
import view.gui.Clipboard;
import view.gui.PaintCanvas;
import view.gui.ShapeCollection;

public class CommandFactory {
    ShapeCollection shapes = ShapeCollection.getInstance();
    Clipboard clipboard = Clipboard.getInstance();
    public ICommand createCommand(EventName eventName, PaintCanvas paintCanvas) {
        boolean isSelected = shapes.isOneSelected();
        switch (eventName) {
            case UNDO:
                return new UndoCommand(paintCanvas);
            case REDO:
                return new RedoCommand(paintCanvas);
            case COPY:
                if (isSelected) {
                    return new CopyCommand();
                }
                else {
                    return new NullCommand(paintCanvas);
                }
            case PASTE:
                if (clipboard.getShapes().size() <1) {
                    return new NullCommand(paintCanvas);
                }
                else {
                    return new PasteCommand(paintCanvas);
                }
            case DELETE:
                if (isSelected) {
                    return new DeleteCommand(paintCanvas);
                }
                else {
                    return new NullCommand(paintCanvas);
                }
            case GROUP:
                if (isSelected) {
                    return new GroupCommand(paintCanvas);
                }
                else {
                    return new NullCommand(paintCanvas);
                }

            case UNGROUP:
                if (isSelected) {
                    return new UngroupCommand(paintCanvas);
                }
                else {
                    return new NullCommand(paintCanvas);
                }
            default:
                throw new IllegalArgumentException("Unknown command name: " + eventName);
        }
    }
}

