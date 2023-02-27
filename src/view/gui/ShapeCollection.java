package view.gui;

import view.IDrawShape;
import view.IShape;
import model.*;


import java.util.ArrayList;
import java.awt.Rectangle;

public class ShapeCollection {
    //Will have to add in all shapes in future. This is simply a stack of all shapes generated.
    private static ShapeCollection instance = null;
    private ArrayList<IShape> shapes;
    //creating a sliding index for undo/redo
    private int indx = 0;

    private ShapeCollection() {
        shapes = new ArrayList<>();
    }

    CollectionHistory history = CollectionHistory.getInstance();

    public static ShapeCollection getInstance() {
        //if no instance, initializes one
        if (instance == null) {
            instance = new ShapeCollection();

        }
        return instance;
    }

    public void addShape(IShape shape) {
        //if a new shape is added after undoing, the stack will drop what could have been redone. This clears the "cache" and simplifies the redo action
        shapes.add(shape);
        setSelectedShapes(-1,-1,-1,-1);
        history.addState(new ArrayList<>(shapes));
    }

    public void removeShape() {
        //lower bounding undo
        if (indx > 0){
            indx -= 1;
        }

    }

    public void setShapes(ArrayList<IShape> currentState) {
        shapes.clear();
        for (IShape shape: currentState) {
            shapes.add(shape);
        }
    }

    public void undoShape() {
        history.undo();
        setShapes(history.getCurrentState());
    }

    public void redoShape() {
        //upper bounding redo
        if (indx < shapes.size()) {
            indx += 1;
        }
        history.redo();
        setShapes(history.getCurrentState());
    }

    public ArrayList<IShape> getShapes() {
        //return just the list
        return shapes;
    }

    public void setSelectedShapes(int start_x, int start_y, int end_x, int end_y) {
        for (IShape shape: shapes) {
            shape.checkSelected(start_x, start_y, end_x, end_y);
        }
    }


    public ArrayList findSelected() {
        int index = 0;
        ArrayList<Integer> selectedValues = new ArrayList<>();
        for (IShape shape: shapes) {
            if (shape.isSelected()){
                selectedValues.add(index);
            }
            index+=1;
        }
        return selectedValues;
    }

    public IShape getShapeIndex(int index) {
        IShape shape = shapes.get(index);
        return shape;
    }

    public void replaceShape(Integer idx, IShape shape) {
        shapes.set(idx, shape);
        history.addState(shapes);
    }

    public int[] getCoorIndex(int index) {
        IShape shape = shapes.get(index);
        return shape.getCoord();
    }

}
