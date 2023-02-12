package view.gui;

import view.IDrawShape;

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
}

