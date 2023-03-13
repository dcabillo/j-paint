package view;
import java.awt.*;
import java.util.ArrayList;

import model.*;


public interface IShape {
    void draw(Graphics2D g2d);
    void checkSelected(int start_x, int end_x, int start_y, int end_y);
    boolean isSelected();
    void selectShape();
    int[] getCoord();
    void addShape(IShape shape);
    void unselectShape();
    IShape moveShape( int dx, int dy);
    ArrayList<IShape> unGroup();
    IShape copyShape();

}
