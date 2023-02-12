package view.gui;

import view.IDrawShape;

import java.awt.*;

public class Ellipse implements IDrawShape {
    private int width;
    private int height;
    private int sx;
    private int sy;

    public Ellipse(int sx, int sy, int width, int height) {
        this.width = width;
        this.height = height;
        this.sx = sx;
        this.sy = sy;

    }
    public void draw(Graphics2D g2d) {
        g2d.drawOval(this.sx, this.sy, this.width, this.height);
    }

    public void fill(Graphics2D g2d) {
        g2d.fillOval(this.sx, this.sy, this.width, this.height);
    }
}

