package view;

import java.awt.*;

public interface IDrawShape {
    void draw(Graphics2D g2d);
    void fill(Graphics2D g2d);
    int[] getCoords();
}
