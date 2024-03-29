package view.gui;

import view.IDrawShape;
import view.IShape;
import model.*;

import java.awt.*;
import java.util.ArrayList;

public class Shape implements IShape {
    private IDrawShape shape;
    public Color primaryColor;
    public Color secondaryColor;
    public String shading;
    private boolean selected;

    public Shape(IDrawShape shape, Color primaryColor, Color secondaryColor, String shading){
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
        this.shading = shading;
        this.selected = false;
    }


    public void draw(Graphics2D g2d) {
        switch (this.shading) {
            case "OUTLINED":
                g2d.setColor(this.primaryColor);
                this.shape.draw(g2d);
                break;
            case "OUTLINE_AND_FILLED_IN":
                g2d.setColor(this.primaryColor);
                this.shape.fill(g2d);
                g2d.setColor(this.secondaryColor);
                this.shape.draw(g2d);
                break;
            default:
                g2d.setColor(this.primaryColor);
                this.shape.fill(g2d);
                break;

        }
        if (this.selected) {
            g2d.setColor(Color.BLACK);
            this.shape.highlight(g2d);
            g2d.setStroke(new BasicStroke(2.0f));
        }
    }

    public void addShape(IShape shape) {

    }

    public void checkSelected(int start_x, int start_y, int end_x, int end_y) {
        // need to fix the declaration here
        int[] coordinates = this.shape.getCoords();
        if (coordinates[0] <= end_x && coordinates[2] >= start_x && coordinates[1] <= end_y && coordinates[3]>=start_y){
            this.selected = true;
        }
        else {
            this.selected = false;
        }
    }
    public void selectShape() {
        this.selected = true;
    }
    public void unselectShape() {
        this.selected = false;
    }
    public ArrayList<IShape> unGroup() {
        ArrayList<IShape> shapeGroup = new ArrayList<>();
        return shapeGroup;
    }
    public IShape moveShape(int dx, int dy){
        IDrawShape newShape = this.shape.move(dx, dy);
        IShape moved = new Shape(newShape, this.primaryColor, this.secondaryColor, this.shading);
        return moved;
    };


    public IShape copyShape() {
        IDrawShape newShape = this.shape.copyType();
        IShape copy = new Shape(newShape, this.primaryColor, this.secondaryColor, this.shading);
        return copy;

    }
    public boolean isSelected(){
        return this.selected;
    }

    public int[] getCoord() {
        return this.shape.getCoords();
    }

}
