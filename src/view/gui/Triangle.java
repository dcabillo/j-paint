package view.gui;

import view.IDrawShape;
import model.*;

import java.awt.*;

public class Triangle implements IDrawShape {
    private int[] xPoints;
    private int[] yPoints;
    public int width;
    public int height;
    public int sx;
    public int sy;

    public Triangle(int sx, int sy, int width, int height) {
        int[] x = {sx, sx, sx+width};
        int[] y = {sy, sy+height , sy+height};
        this.width = width;
        this.height = height;
        this.sx = sx;
        this.sy = sy;
        this.xPoints= x;
        this.yPoints = y;
    }
    public void draw(Graphics2D g2d) {
        g2d.drawPolygon(this.xPoints, this.yPoints, 3);
    }
    public int[] getCoords(){
        int[] coordArray = new int[] {this.sx, this.sy, this.sx+this.width, this.sy+this.height};
        return coordArray;
    }

    public void fill(Graphics2D g2d) {
        g2d.fillPolygon(this.xPoints, this.yPoints, 3);
    }

    public ShapeType getShapeType(){
        return ShapeType.TRIANGLE;
    }
}
