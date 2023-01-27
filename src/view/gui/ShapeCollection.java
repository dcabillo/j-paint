package view.gui;

import java.util.ArrayList;
import java.awt.Rectangle;

public class ShapeCollection {
    //Will have to add in all shapes in future
    private static ShapeCollection instance = null;
    private final ArrayList<Rectangle> rectangles;
    private int indx = 0;

    private ShapeCollection() {
        rectangles = new ArrayList<>();
    }

    public static ShapeCollection getInstance() {
        if (instance == null) {
            instance = new ShapeCollection();
        }
        return instance;
    }

    public void addRectangle(Rectangle rectangle) {
        if (indx != rectangles.size()-1){
            rectangles.subList(indx, rectangles.size()).clear();
        }
        rectangles.add(rectangle);
        indx += 1;
    }

    public void removeRectangle() {
        if (indx > 0){
            indx -= 1;
        }

    }

    public void redoRectangle() {
        if (indx < rectangles.size()) {
            indx += 1;
        }
    }

    public ArrayList<Rectangle> getRectangles() {
        return new ArrayList<>(rectangles.subList(0, indx));
    }
}
