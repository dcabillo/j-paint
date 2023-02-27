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
    private int[] HLxPoints;
    private int[] HLyPoints;

    public Triangle(int sx, int sy, int width, int height) {
        int[] x = {sx, sx, sx+width};
        int[] y = {sy, sy+height , sy+height};
        int[] HLx = {sx-5, sx-5, sx+width+10};
        int[] HLy = {sy-10, sy+height+5 , sy+height+5};
        this.width = width;
        this.height = height;
        this.sx = sx;
        this.sy = sy;
        this.xPoints= x;
        this.yPoints = y;
        this.HLxPoints = HLx;
        this.HLyPoints = HLy;
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
    public void highlight(Graphics2D g2d) {
        float[] dashPattern = {5f, 5f};
        BasicStroke dashedStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, dashPattern, 0f);
        g2d.setStroke(dashedStroke);
        g2d.drawPolygon(this.HLxPoints, this.HLyPoints, 3);
    }

    public ShapeType getShapeType(){
        return ShapeType.TRIANGLE;
    }
}
