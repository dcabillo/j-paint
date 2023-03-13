package view;

import java.awt.*;
import model.*;

public interface IDrawShape {
    void draw(Graphics2D g2d);
    void fill(Graphics2D g2d);
    void highlight(Graphics2D g2d);
    int[] getCoords();
    IDrawShape move(int dx, int dy);
    IDrawShape copyType();

}
