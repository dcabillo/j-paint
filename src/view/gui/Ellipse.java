package view.gui;

import view.IDrawShape;
import model.*;

import java.awt.*;

public class Ellipse implements IDrawShape {
    public int width;
    public int height;
    public int sx;
    public int sy;

    public Ellipse(int sx, int sy, int width, int height) {
        this.width = width;
        this.height = height;
        this.sx = sx;
        this.sy = sy;

    }
    public void draw(Graphics2D g2d) {
        g2d.drawOval(this.sx, this.sy, this.width, this.height);
    }
    public int[] getCoords(){
        int[] coordArray = new int[] {this.sx, this.sy, this.sx+this.width, this.sy+this.height};
        return coordArray;
    }

    public void fill(Graphics2D g2d) {
        g2d.fillOval(this.sx, this.sy, this.width, this.height);
    }

    public void highlight(Graphics2D g2d) {
        float[] dashPattern = {5f, 5f};
        BasicStroke dashedStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, dashPattern, 0f);
        g2d.setStroke(dashedStroke);
        g2d.drawOval(this.sx-5, this.sy-5, this.width+10, this.height+10);
    }

    public ShapeType getShapeType(){
        return ShapeType.ELLIPSE;
    }
}

