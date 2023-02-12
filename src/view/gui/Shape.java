package view.gui;

import view.IDrawShape;
import view.IShape;

import java.awt.*;

public class Shape implements IShape {
    private IDrawShape shape;
    private Color primaryColor;

    public Shape(IDrawShape shape, Color color){
        this.primaryColor = color;
        this.shape = shape;
    }


    public void draw(Graphics2D g2d) {
        g2d.setColor(this.primaryColor);
        this.shape.fill(g2d);
    }

}
