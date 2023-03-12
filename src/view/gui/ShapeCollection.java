package view.gui;

import view.IDrawShape;
import view.IShape;
import model.*;


import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.*;
import java.util.Map;

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


    public void setShapes(ArrayList<IShape> currentState) {
        shapes.clear();
        shapes.addAll(currentState);
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

    public void replaceShape(HashMap<Integer, IShape> shiftedShapes) {
        for (Map.Entry<Integer, IShape> entry : shiftedShapes.entrySet()) {
            Integer key = entry.getKey();
            IShape value = entry.getValue();
            value.selectShape();
            shapes.set(key, value);
        }
        history.addState(new ArrayList<>(shapes));

    }

    public void delete(){
        int idx = 0;
        while(idx<shapes.size()){
            if (shapes.get(idx).isSelected()) {
                shapes.remove(idx);
            }
            else {
                idx+=1;
            }
        }
        history.addState(new ArrayList<>(shapes));
    }

    public void copy(ArrayList<IShape> copyList){
        shapes.addAll(copyList);
        history.addState(new ArrayList<>(shapes));
    }

    public void group() {
        int idx = 0;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;

        for (IShape shape:shapes){
            if (shape.isSelected()) {
                int[] coordinates = shape.getCoord();
                min_x = Math.min(coordinates[0], min_x);
                min_y = Math.min(coordinates[1], min_y);
                max_x = Math.max(coordinates[2], max_x);
                max_y = Math.max(coordinates[3], max_y);
            }
        }
        IShape group = new Grouped(min_x, min_y, max_x, max_y);
        while(idx<shapes.size()){
            if (shapes.get(idx).isSelected()) {
                System.out.println(idx);
                group.addShape(shapes.get(idx));
                shapes.remove(idx);
            }
            else {
                idx+=1;
            }

        }

        shapes.add(group);
        history.addState(new ArrayList<>(shapes));
    }

    public void moveShape(int dx, int dy) {
        for (IShape shape: shapes) {
            if (shape.isSelected()){
                shape.moveShape(dx, dy);
            }
        }
    }

    public int[] getCoorIndex(int index) {
        IShape shape = shapes.get(index);
        return shape.getCoord();
    }

}
