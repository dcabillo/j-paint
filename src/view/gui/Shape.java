package view.gui;

import view.IDrawShape;
import view.IShape;

import java.awt.*;

public class Shape implements IShape {
    private IDrawShape shape;
    private Color primaryColor;
    private Color secondaryColor;
    private String shading;

    public Shape(IDrawShape shape, Color primaryColor, Color secondaryColor, String shading){
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
        this.shading = shading;
    }


    public void draw(Graphics2D g2d) {
        switch (this.shading) {
            case "OUTLINED":
                g2d.setColor(this.primaryColor);
                this.shape.draw(g2d);
                break;
            case "OUTLINE_AND_FILLED_IN":
                g2d.setColor(this.primaryColor);
                this.shape.fill(g2d);
                g2d.setColor(this.secondaryColor);
                this.shape.draw(g2d);
                break;
            default:
                g2d.setColor(this.primaryColor);
                this.shape.fill(g2d);
                break;

        }
    }

}
