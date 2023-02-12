package view;
import java.awt.Graphics2D;


public interface IShape {
    void draw(Graphics2D g2d);
    void checkSelected(int start_x, int end_x, int start_y, int end_y);

}
