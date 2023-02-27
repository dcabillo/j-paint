package view.gui;

import view.IShape;

import java.util.ArrayList;

public class Clipboard {
    private static Clipboard instance = null;
    private final ArrayList<IShape> clipboard;

    private Clipboard() {clipboard = new ArrayList<>();}

    public static Clipboard getInstance() {
        if (instance == null) {
            instance = new Clipboard();
        }
        return instance;
    }

    public void addShape(IShape shape) {
        clipboard.add(shape);
    }

    public ArrayList<IShape> getShapes() {
        //return just the list
        return clipboard;
    }


}
