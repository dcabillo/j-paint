package view.gui;

import view.IDrawShape;

import java.awt.*;

public class Rectangle implements IDrawShape {
    private int width;
    private int height;
    private int sx;
    private int sy;

    public Rectangle(int sx, int sy, int width, int height) {
        this.width = width;
        this.height = height;
        this.sx = sx;
        this.sy = sy;
    }
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.fillRect(this.sx, this.sy, this.width, this.height);
    }

    public void fill(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.drawRect(this.sx, this.sy, this.width, this.height);
    }
}

