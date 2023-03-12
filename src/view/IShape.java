package view;
import java.awt.*;
import model.*;


public interface IShape {
    void draw(Graphics2D g2d);
    void checkSelected(int start_x, int end_x, int start_y, int end_y);
    boolean isSelected();
    Color getPrimaryColor();
    Color getSecondaryColor();
    String getShadingType();
    ShapeType getShape();
    void selectShape();
    int[] getCoord();
    public void addShape(IShape shape);
    public void unselectShape();
    public void moveShape( int dx, int dy);

}
