package edu.easysoft.game.playground;

import edu.easysoft.game.mechanics.CellAction;

public class Cell {
    private CellAction cellAction;
    private Hexagon hexagon;
    private boolean isMouseMoved;
    private boolean isSelected;
    private boolean isOnThePath;
    private boolean isActionAttached;
    private boolean isBarrier;

    Cell(Hexagon hexagon){
        this.hexagon = hexagon;

    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {

        // todo:barrier
        isSelected = selected;
    }

    public boolean isMouseMoved() {
        return isMouseMoved;
    }

    public void setMouseMoved(boolean mouseMoved) {
        isMouseMoved = mouseMoved;
    }
    public CellAction getCellAction() {
        return cellAction;
    }

    public void setCellAction(CellAction cellAction) {
        this.cellAction = cellAction;
    }

    public Hexagon getHexagon() {
        return hexagon;
    }

    public void setHexagon(Hexagon hexagon) {
        this.hexagon = hexagon;
    }

    public boolean isOnThePath() {
        return isOnThePath;
    }

    public void setOnThePath(boolean onThePath) {
        // todo:barrier
        isOnThePath = onThePath;
    }

    public boolean isActionAttached() {
        return isActionAttached;
    }

    public void setActionAttached(boolean actionAttached) {
        isActionAttached = actionAttached;
    }

}
