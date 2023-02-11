package view.gui;

import view.IDrawShape;
import view.IShape;

import java.awt.*;

public class Shape implements IShape {
    private IDrawShape shape;

    public Shape(IDrawShape shape){
        this.shape = shape;
    }


    public void draw(Graphics2D g2d) {
        this.shape.fill(g2d);
    }
}
