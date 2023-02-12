package view.gui;

import view.IDrawShape;
import view.IShape;
import model.*;

import java.awt.*;

public class Shape implements IShape {
    private IDrawShape shape;
    private Color primaryColor;
    private Color secondaryColor;
    private String shading;
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
    }

    public void checkSelected(int start_x, int start_y, int end_x, int end_y) {
        // need to fix the declaration here
        int[] coordinates = this.shape.getCoords();
        if (coordinates[0] <= end_x && coordinates[2] >= start_x && coordinates[1] <= end_y && coordinates[3]>=start_y){
            System.out.println("Sanity Check");
            this.selected = true;
        }
    }

    public boolean isSelected(){
        return this.selected;
    }
    public ShapeType getShape() {
        return this.shape.getShapeType();
    }
    public int[] getCoord() {
        return this.shape.getCoords();
    }

}
