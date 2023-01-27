package view.gui;

import java.util.ArrayList;
import java.awt.Rectangle;

public class ShapeCollection {
    //Will have to add in all shapes in future
    private static ShapeCollection instance = null;
    private final ArrayList<Rectangle> rectangles;
    //creating a sliding index for undo/redo
    private int indx = 0;

    private ShapeCollection() {
        rectangles = new ArrayList<>();
    }

    public static ShapeCollection getInstance() {
        //if no instance, initializes one
        if (instance == null) {
            instance = new ShapeCollection();
        }
        return instance;
    }

    public void addRectangle(Rectangle rectangle) {
        //if a new shape is added after undoing, the stack will drop what could have been redone. This clears the "cache" and simplifies the redo action
        if (indx != rectangles.size()-1){
            rectangles.subList(indx, rectangles.size()).clear();
        }
        rectangles.add(rectangle);
        indx += 1;
    }

    public void removeRectangle() {
        //lower bounding undo
        if (indx > 0){
            indx -= 1;
        }

    }

    public void redoRectangle() {
        //upper bounding redo
        if (indx < rectangles.size()) {
            indx += 1;
        }
    }

    public ArrayList<Rectangle> getRectangles() {
        //return just the list
        return new ArrayList<>(rectangles.subList(0, indx));
    }
}
