package controller;

import model.persistence.ApplicationState;
import view.IDrawShape;
import view.IShape;
import view.gui.Ellipse;
import view.gui.Rectangle;
import view.gui.Triangle;
import java.awt.Color;
import model.*;

import javax.swing.plaf.synth.ColorType;


public class ShapeSwitch {
    ShapeType shape;
    ShapeColor primaryColor;
    ShapeColor secondaryColor;
    ShapeShadingType shading;
    public ShapeSwitch(ApplicationState applicationState){
        this.shape = applicationState.getActiveShapeType();
        this.primaryColor = applicationState.getActivePrimaryColor();
        this.secondaryColor = applicationState.getActiveSecondaryColor();
        this.shading = applicationState.getActiveShapeShadingType();

    }

    public IDrawShape getShape(int sx, int sy, int width, int height) {
        switch (this.shape) {
            case TRIANGLE:
                IDrawShape tri = new Triangle(sx, sy, width, height);
                return tri;
            case ELLIPSE:
                IDrawShape ellipse = new Ellipse(sx, sy, width, height);
                return ellipse;
            default:
                IDrawShape rec = new Rectangle(sx, sy, width, height);
                return rec;
        }
    }

    public IDrawShape getNewShape(int sx, int sy, int width, int height, ShapeType type){
        switch (type) {
            case TRIANGLE:
                IDrawShape tri = new Triangle(sx, sy, width, height);
                return tri;
            case ELLIPSE:
                IDrawShape ellipse = new Ellipse(sx, sy, width, height);
                return ellipse;
            default:
                IDrawShape rec = new Rectangle(sx, sy, width, height);
                return rec;
        }
    }

    public Color getColor(ShapeColor color) {
        switch (color) {
            case BLUE:
                return Color.BLUE;
            case CYAN:
                return Color.CYAN;
            case DARK_GRAY:
                return Color.DARK_GRAY;
            case GRAY:
                return Color.GRAY;
            case GREEN:
                return Color.GREEN;
            case LIGHT_GRAY:
                return Color.LIGHT_GRAY;
            case MAGENTA:
                return Color.MAGENTA;
            case ORANGE:
                return Color.ORANGE;
            case PINK:
                return Color.PINK;
            case RED:
                return Color.RED;
            case WHITE:
                return Color.WHITE;
            case YELLOW:
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }
    }


    public String getShading(){
        switch (this.shading){
            case OUTLINE:
                return "OUTLINED";
            case OUTLINE_AND_FILLED_IN:
                return "OUTLINE_AND_FILLED_IN";
            default:
                return "FILLED_IN";
        }
    }

    public Color getPrimary() {
        return getColor(this.primaryColor);
    }
    public Color getSecondary() {
        return getColor(this.secondaryColor);
    }
}

