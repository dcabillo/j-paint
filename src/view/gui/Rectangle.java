package view.gui;

import model.*;

import view.IDrawShape;

import java.awt.*;

public class Rectangle implements IDrawShape {
    public int width;
    public int height;
    public int sx;
    public int sy;

    public Rectangle(int sx, int sy, int width, int height) {
        this.width = width;
        this.height = height;
        this.sx = sx;
        this.sy = sy;
    }
    public void draw(Graphics2D g2d) {
        g2d.drawRect(this.sx, this.sy, this.width, this.height);
    }


    public int[] getCoords(){
        int[] coordArray = new int[] {this.sx, this.sy, this.sx+this.width, this.sy+this.height};
        return coordArray;
    }

    public void highlight(Graphics2D g2d) {
        float[] dashPattern = {5f, 5f};
        BasicStroke dashedStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, dashPattern, 0f);
        g2d.setStroke(dashedStroke);
        g2d.drawRect(this.sx-5, this.sy-5, this.width+10, this.height+10);
    }

    public void fill(Graphics2D g2d) {
        g2d.fillRect(this.sx, this.sy, this.width, this.height);
    }


    public ShapeType getShapeType(){
        return ShapeType.RECTANGLE;
    }
}

