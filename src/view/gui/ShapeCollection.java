package view.gui;

import view.IShape;


import java.util.ArrayList;
import java.awt.Rectangle;

public class ShapeCollection {
    //Will have to add in all shapes in future. This is simply a stack of all shapes generated.
    private static ShapeCollection instance = null;
    private final ArrayList<IShape> shapes;
    //creating a sliding index for undo/redo
    private int indx = 0;

    private ShapeCollection() {
        shapes = new ArrayList<>();
    }

    public static ShapeCollection getInstance() {
        //if no instance, initializes one
        if (instance == null) {
            instance = new ShapeCollection();
        }
        return instance;
    }

    public void addShape(IShape shape) {
        //if a new shape is added after undoing, the stack will drop what could have been redone. This clears the "cache" and simplifies the redo action
        if (indx != shapes.size()-1){
            shapes.subList(indx, shapes.size()).clear();
        }
        shapes.add(shape);
        indx += 1;
    }

    public void removeShape() {
        //lower bounding undo
        if (indx > 0){
            indx -= 1;
        }

    }

    public void redoShape() {
        //upper bounding redo
        if (indx < shapes.size()) {
            indx += 1;
        }
    }

    public ArrayList<IShape> getShapes() {
        //return just the list
        return new ArrayList<>(shapes.subList(0, indx));
    }
}
