package view.gui;

import view.IDrawShape;
import view.IShape;
import java.util.*;
import model.*;

import java.awt.*;

public class Grouped implements IShape {
    private IDrawShape shape;
    private boolean selected;
    private ArrayList<IShape> group = new ArrayList<>();
    private int[] coordinates;
    public int width;
    public int height;
    public int sx;
    public int sy;

    public Grouped(int start_x, int start_y, int end_x, int end_y) {
        int[] coord = new int[] {start_x, start_y, end_x, end_y};
        this.coordinates = coord;
        this.selected = true;
        this.width = end_x - start_x;
        this.height = end_y - start_y;
        this.sx = start_x;
        this.sy = start_y;
    }

    public void addShape(IShape shape) {
        shape.unselectShape();
        group.add(shape);
    }

    public ArrayList<IShape> unGroup() {
        ArrayList<IShape> shapeGroup = new ArrayList<>();
        for (IShape shape: group) {
            shapeGroup.add(shape);
        }
        return shapeGroup;
    }

    public void draw(Graphics2D g2d) {
        for (IShape shape: group) {
            shape.draw(g2d);
        }
        if (this.selected) {
            g2d.setColor(Color.BLACK);
            float[] dashPattern = {5f, 5f};
            BasicStroke dashedStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, dashPattern, 0f);
            g2d.setStroke(dashedStroke);
            g2d.drawRect(this.sx-5, this.sy-5, this.width+10, this.height+10);
        }
    }
    public void checkSelected(int start_x, int start_y, int end_x, int end_y) {
        if (this.coordinates[0] <= end_x && this.coordinates[2] >= start_x && this.coordinates[1] <= end_y && this.coordinates[3]>=start_y){
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
    public boolean isSelected() {
        return this.selected;
    }
    public Color getPrimaryColor() {return Color.red;}
    public Color getSecondaryColor() {return Color.red;}
    public String getShadingType() {return "none";}
    public ShapeType getShape() {
        return ShapeType.RECTANGLE;
    }

    public void moveShape(int dx, int dy) {
        for (IShape shape: group) {
            shape.moveShape(dx, dy);
        }
        this.sx +=dx;
        this.sy += dy;
    }
    public int[] getCoord() {
        return this.coordinates;
    }

}
