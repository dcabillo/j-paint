package view.gui;

import view.IDrawShape;

import java.awt.*;

public class Triangle implements IDrawShape {
    private int[] xPoints;
    private int[] yPoints;

    public Triangle(int sx, int sy, int width, int height) {
        int[] x = {sx, sx, sx+width};
        int[] y = {sy, sy+height , sy+height};
        this.xPoints= x;
        this.yPoints = y;
    }
    public void draw(Graphics2D g2d) {
        g2d.fillPolygon(this.xPoints, this.yPoints, 3);
    }

    public void fill(Graphics2D g2d) {
        g2d.drawPolygon(this.xPoints, this.yPoints, 3);
    }
}
