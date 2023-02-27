package view.gui;

import java.util.ArrayList;
import view.IShape;

public class CollectionHistory {
    private static CollectionHistory instance = null;
    private final ArrayList<ArrayList<IShape>> history;

    private int indx = 0;
    private CollectionHistory() {
        history = new ArrayList<ArrayList<IShape>>();
        history.add(new ArrayList<IShape>());
    }

    public static CollectionHistory getInstance() {
        if (instance == null) {
            instance = new CollectionHistory();
        }
        return instance;
    }

    public void addState(ArrayList<IShape> state) {
        if (indx != history.size()-1) {
            history.subList(indx, history.size()).clear();
        }

        history.add(state);
        indx +=1;
    }

    public void undo() {
        if (indx > 0) {
            indx -= 1;
        }
    }

    public void redo() {
        if (indx < history.size() -1) {
            indx += 1;
        }
    }

    public ArrayList<IShape> getCurrentState() {
        return history.get(indx);
    }

}
